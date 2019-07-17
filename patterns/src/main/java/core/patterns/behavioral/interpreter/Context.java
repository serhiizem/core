package core.patterns.behavioral.interpreter;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class Context {

    private static final Function<String, String> MATCH_ALL_COLUMNS = identity();
    private static final Predicate<String> NO_FILTERING = s -> true;

    private final Map<String, List<Row>> database;

    @Setter
    private String table;
    private String column;
    private int columnIndex = -1;

    private Function<String, String> columnMapper = MATCH_ALL_COLUMNS;
    @Setter
    private Predicate<String> filter = NO_FILTERING;

    List<String> search() {
        List<String> result = database.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(table))
                .flatMap(entry -> entry.getValue().stream())
                .map(Row::toString)
                .map(columnMapper)
                .filter(filter)
                .collect(toList());

        clear();

        return result;
    }

    private void clear() {
        this.column = "";
        this.columnMapper = MATCH_ALL_COLUMNS;
        this.filter = NO_FILTERING;
    }

    void setColumn(String column) {
        this.column = column;
        defineColumnMapper();
    }

    private void defineColumnMapper() {
        if (column.equals("*")) {
            columnIndex = -1;
        }
        if (column.equals("firstName")) {
            columnIndex = 0;
        }
        if (column.equals("lastName")) {
            columnIndex = 1;
        }
        if (columnIndex != -1) {
            columnMapper = s -> s.split(" ")[columnIndex];
        }
    }
}
