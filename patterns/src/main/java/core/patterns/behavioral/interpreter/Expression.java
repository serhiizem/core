package core.patterns.behavioral.interpreter;

import java.util.List;

public interface Expression {
    List<String> execute(Context context);
}
