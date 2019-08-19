package core.generics;

import java.util.List;
import java.util.Set;

@SuppressWarnings("SameParameterValue")
class Generics {

    void unsafeAdd(List rawList, Integer faultyValue) {
        //noinspection unchecked
        rawList.add(faultyValue);
    }

    int safelyCountOccurrences(Set<?> s1, Set<?> s2) {
        int count = 0;
        for (Object o : s1) {
            if (s2.contains(o)) {
                count++;
            }
        }
        return count;
    }
}
