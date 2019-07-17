package core.patterns.behavioral.interpreter;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class Where implements Expression {

    private final Predicate<String> filter;

    @Override
    public List<String> execute(Context context) {
        context.setFilter(filter);
        return context.search();
    }
}
