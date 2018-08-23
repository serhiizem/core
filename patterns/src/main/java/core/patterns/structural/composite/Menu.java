package core.patterns.structural.composite;

public class Menu extends MenuComponent {
    public Menu(String name, String url) {
        super(name, url);
    }

    public MenuComponent add(MenuComponent component) {
        components.add(component);
        return component;
    }

    public MenuComponent remove(MenuComponent component) {
        components.remove(component);
        return component;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(print());
        sb.append("\n");
        for (MenuComponent component : components) {
            String childAsString = component.toString();
            sb.append(childAsString);
            sb.append("\n");
        }
        return sb.toString();
    }
}
