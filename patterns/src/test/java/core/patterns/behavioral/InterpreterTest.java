package core.patterns.behavioral;

import core.patterns.behavioral.interpreter.Context;
import core.patterns.behavioral.interpreter.From;
import core.patterns.behavioral.interpreter.Select;
import core.patterns.behavioral.interpreter.Where;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static core.patterns.behavioral.TestUtil.INTERPRETER_TEST_DATABASE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interpreter test")
class InterpreterTest {

    private Context context;

    @BeforeEach
    void setup() {
        context = new Context(INTERPRETER_TEST_DATABASE);
    }

    @Test
    @DisplayName("If no filtering or projection is specified - return whole result set")
    void shouldDisplayAllRecordsWithAllColumns() {
        List<String> result = new Select("*", new From("people"))
                .execute(context);

        assertEquals("[Chris Fehn, Corey Taylor, Jay Weinberg]", result.toString());
    }

    @Test
    @DisplayName("Result set should contain only first name as it was specified in 'SELECT' clause")
    void shouldDisplayOnlyFirstNameOfAllRecords() {
        List<String> result = new Select("firstName", new From("people"))
                .execute(context);

        assertEquals("[Chris, Corey, Jay]", result.toString());
    }

    @Test
    @DisplayName("Result set should contain only last name as it was specified in 'SELECT' clause")
    void shouldDisplayOnlyLastNameOfAllRecords() {
        List<String> result = new Select("lastName", new From("people"))
                .execute(context);

        assertEquals("[Fehn, Taylor, Weinberg]", result.toString());
    }

    @Test
    @DisplayName("Should filter result set by the predicate defined in 'WHERE' clause")
    void shouldRetainRecordsThatConformToTheFilter() {
        List<String> result =
                new Select("firstName",
                        new From("people",
                                new Where(record -> record.startsWith("C"))))
                        .execute(context);

        assertEquals("[Chris, Corey]", result.toString());
    }
}
