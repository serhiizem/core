package core.patterns.behavioral.interpreter;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Select implements Expression {

    private final String column;
    private final From from;

    @Override
    public List<String> execute(Context context) {
        context.setColumn(column);
        return from.execute(context);
    }
}
