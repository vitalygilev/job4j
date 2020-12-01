package design.isp;

import java.util.ArrayList;
import java.util.List;

public class MenuItem implements Actions {

    private final MenuItem parent;
    private final List<MenuItem> children = new ArrayList<>();
    private final String name;
    private MenuOutput mOut;

    public MenuItem(MenuItem parent, String name) {
        this.name = name;
        this.parent = parent;
        if (this.parent != null) {
            this.parent.children.add(this);
        }
    }

    public MenuItem(MenuItem parent, String name, MenuOutput mOut) {
        this.parent = parent;
        this.name = name;
        this.mOut = mOut;
        if (this.parent != null) {
            this.parent.children.add(this);
        }
    }

    public String getName() {
        return name;
    }

    public MenuItem getParent() {
        return parent;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public MenuOutput getMOut() {
        return mOut;
    }

    @Override
    public boolean doAction() {
        return false;
    }
}
