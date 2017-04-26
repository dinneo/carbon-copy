package org.distbc.planner;

import com.google.inject.Inject;
import org.distbc.data.structures.Catalog;
import org.distbc.data.structures.DataStructureFactory;
import org.distbc.data.structures.Table;
import org.distbc.data.structures.TempTable;
import org.distbc.data.structures.TopLevelDataStructure;
import org.distbc.data.structures.Txn;
import org.distbc.data.structures.TxnManager;
import org.distbc.parser.ParsingResult;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * While every sensible query plan can be imagined as a tree this query planner thinks of as a series of independent
 * query plans (swim lanes) that merge together at some point.
 * Therefore, it starts looking at every table independently and tries to figure out how it can mutate each table.
 * At some point two of these swim lanes merge and become one.
 *
 * Limitations:
 *    - column names need to be unique
 *    - only lower case keywords
 */
class QueryPlannerImpl implements QueryPlanner {

    private final Catalog catalog;
    private final DataStructureFactory dsFactory;
    private final TxnManager txnManager;

    @Inject
    QueryPlannerImpl(Catalog catalog, DataStructureFactory dsFactory, TxnManager txnManager) {
        this.catalog = catalog;
        this.dsFactory = dsFactory;
        this.txnManager = txnManager;
    }

    @Override
    public QueryPlan generateQueryPlan(ParsingResult parsingResult) {
        List<Table> tables = orderTablesInExecutionOrder(parsingResult);
        Map<String, QueryPlanSwimLane> tableNameToSwimLand = new HashMap<>(tables.size());
        QueryPlanImpl qp = new QueryPlanImpl();
        Txn txn = txnManager.beginTransaction();

        try {
            try {
                tables.forEach(table -> {
                    TempTable tt = dsFactory.newTempTableFromTable(table, txn);
                    QueryPlanSwimLane sl = new QueryPlanSwimLane(tt);
                    // figure out projections first
                    sl.addOperation(generateProjectionForTable(table, parsingResult));
                    // then do selections
                    if (parsingResult.getWhereClauses().size() > 0) {
                        sl.addOperation(generateSelectionForTable(table, parsingResult));
                    }
                    qp.addSwimLane(sl);
                    tableNameToSwimLand.put(table.getName(), sl);
                });
            } finally {
                txn.commit();
            }
        } catch (IOException xcp) {
            throw new RuntimeException(xcp);
        }

        // each of these swim lanes can be kicked off already
        // but we don't do that...
        // then determine how tables feed into joins
        parsingResult.getJoinClauses().forEach(joinClause -> {
            // TODO: get both tables out of the joinClause
            // potentially parse the string again ... not crazy cool but gets us there :)
            // create new swim lane from child swim lanes
            // let's see how this goes for us :)
            qp.addSwimLane(generateJoinForSwimLanes(tableNameToSwimLand.get(""), tableNameToSwimLand.get(""), parsingResult));
        });

        return qp;
    }

    private List<Table> orderTablesInExecutionOrder(ParsingResult parsingResult) {
        return parsingResult.getTableNames().stream()
                .map(tableName -> catalog.get(tableName, Table.class))
                .sorted(Comparator.comparing(TopLevelDataStructure::getName))
                .collect(Collectors.toList());
    }

    private Operation generateProjectionForTable(Table table, ParsingResult parsingResult) {
        return new Projection(parsingResult.getProjectionColumnNames(), table.getColumnNames());
    }

    private Operation generateSelectionForTable(Table table, ParsingResult parsingResult) {
        List<String> columnsOnTable = table.getColumnNames();
//        List<String> allWhereClauses = parsingResult.getWhereClauses();
        List<ParsingResult.BinaryOperation> bos = parsingResult.getBinaryOperations();
        bos = bos.stream()
                .filter(bo -> columnsOnTable.indexOf(bo.operand1) >= 0)
                .collect(Collectors.toList());
        // get all where clauses that are interesting for the table in question
        // convert the tree into a series of strings
        // selections with literals only
//        return new Selection(bos);
        return null;
    }

    private QueryPlanSwimLane generateJoinForSwimLanes(QueryPlanSwimLane sl1, QueryPlanSwimLane sl2, ParsingResult parsingResult) {
        return null;
    }
}
