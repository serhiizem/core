package core.patterns.behavioral;

import core.patterns.behavioral.interpreter.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class TestUtil {

    private TestUtil() {
    }

    static final Map<String, List<Row>> INTERPRETER_TEST_DATABASE = new HashMap<>();

    static {
        List<Row> rows = asList(
                new Row("Chris", "Fehn"),
                new Row("Corey", "Taylor"),
                new Row("Jay", "Weinberg")
        );

        INTERPRETER_TEST_DATABASE.put("people", rows);
    }
}
