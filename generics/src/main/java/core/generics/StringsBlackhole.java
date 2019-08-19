package core.generics;

import java.util.List;
import java.util.function.Consumer;

public class StringsBlackhole implements Consumer<List<String>> {

    @Override
    public void accept(List<String> strings) {
        for (String s : strings) {
            char[] chars = s.toCharArray();
            //noinspection StatementWithEmptyBody
            for (char c : chars) {
            }
        }
    }
}
