package core.patterns.behavioral.interpreter;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class From implements Expression {

    private final String table;
    private Where where;

    public From(String table) {
        this.table = table;
    }

    @Override
    public List<String> execute(Context context) {
        context.setTable(table);
        if (where != null) {
            return where.execute(context);
        }
        return context.search();
    }
}
