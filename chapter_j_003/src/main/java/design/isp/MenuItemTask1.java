package design.isp;

public class MenuItemTask1 extends MenuItem implements Actions {

    public MenuItemTask1(MenuItem parent, String name, MenuOutput mOut) {
        super(parent, name, mOut);
    }

    @Override
    public boolean doAction() {
        super.getMOut().output("This is a Task's 1 action!");
        return true;
    }

}
