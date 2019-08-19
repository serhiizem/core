package core.generics;

import core.generics.model.Employee;
import core.generics.model.Person;
import core.generics.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static core.generics.TestUtil.STRINGS_BLACKHOLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("UnnecessaryLocalVariable")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = GenericsTestConfig.class)
class GenericsTest {

    @Autowired
    private Generics generics;

    @Test
    @DisplayName("Should throw error in runtime if value of wrong type is added to raw list")
    void shouldThrowErrorWhenAddingValueOfWrongTypeToRawList() {
        assertThrows(ClassCastException.class, () -> {
            List<String> strings = new ArrayList<>();

            generics.unsafeAdd(strings, 15);

            STRINGS_BLACKHOLE.accept(strings);
        });
    }

    @Test
    void shouldAllowToCompareArbitraryCollectionsWhenTypeParameterIsNotImportant() {
        Set<String> strings = new HashSet<>();
        Set<Number> numbers = new HashSet<>();

        strings.add("s1");
        strings.add("s2");

        numbers.add(1);
        numbers.add(4);

        int occurrences = generics.safelyCountOccurrences(strings, numbers);

        assertEquals(0, occurrences);
    }

    @Test
    @DisplayName("Arrays are covariant, so it is possible to insert any object of a subtype " +
            "to the array of supertypes")
    void shouldAllowReplacingEmployeeByStudent() {
        assertThrows(ArrayStoreException.class, () -> {
            Employee[] employees = new Employee[]{
                    new Employee("#3513"),
                    new Employee("#5624"),
                    new Employee("#0513")
            };

            Person[] people = employees;

            //noinspection ConstantConditions
            people[0] = new Student("Darren");
        });
    }

    @Test
    @DisplayName("Generic array creation is prohibited by Java specification because covariant nature" +
            "of array would erase any typesafety introduced by generics")
    void shouldNotAllowCreatingGenericArrays() {
        //List<String>[] stringsLists = new ArrayList<>[2];
        //List<Integer> integers = Arrays.asList(5, 6, 12, 4);
        //Object[] objects = stringsLists;
        //objects[0] = integers;
        //String s = stringsLists[0].get(0) -------> ClassCastException
    }
}
