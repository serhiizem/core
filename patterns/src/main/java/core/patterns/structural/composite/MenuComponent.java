package core.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("StringBufferReplaceableByString")
public abstract class MenuComponent {
    protected String name;
    protected String url;

    public MenuComponent(String name, String url) {
        this.name = name;
        this.url = url;
    }

    protected List<MenuComponent> components = new ArrayList<>();

    protected String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ")
                .append(name)
                .append(", url: ")
                .append(url);
        return sb.toString();
    }

    public abstract String toString();
}
