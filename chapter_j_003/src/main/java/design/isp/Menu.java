package design.isp;

import java.util.Iterator;
import java.util.Stack;

public class Menu implements Iterable<MenuItem> {

    private final MenuItem root = new MenuItem(null, "root");
    private final MenuOutput mOut;
    private final MenuInput mIn;

    public MenuItem getRoot() {
        return root;
    }

    public Menu(MenuOutput mOut, MenuInput mIn) {
        this.mOut = mOut;
        this.mIn = mIn;
    }

    @Override
    public Iterator<MenuItem> iterator() {

        return new Iterator<>() {

            private MenuItem curItem = getRoot();
            private final Stack<Integer> positions = new Stack<>();

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (curItem.getChildren().size() > 0) {
                    curItem = curItem.getChildren().get(0);
                    positions.push(0);
                    result = true;
                } else {
                    int curPos = positions.pop();
                    if (curItem.getParent().getChildren().size() > ++curPos) {
                        curItem = curItem.getParent().getChildren().get(curPos);
                        positions.push(curPos);
                        result = true;
                    } else {
                        while (!positions.empty()) {
                            curPos = positions.pop();
                            curItem = curItem.getParent();
                            if (curItem.getParent().getChildren().size() > ++curPos) {
                                curItem = curItem.getParent().getChildren().get(curPos);
                                curPos = positions.pop();
                                positions.push(++curPos);
                                result = true;
                                break;
                            }
                        }
                    }
                }
                return result;
            }

            @Override
            public MenuItem next() {
                return curItem;
            }

        };
    }

    public void showMenu() {
        int num = 1;
        for (MenuItem curItem : this) {
            mOut.output(new StringBuilder().append(num++).append(") ").append(curItem.getName()).toString());
        }
    }

    public int selectItem(String ask) {
        return mIn.input(ask);
    }

    public boolean doActionByItemNumber(int itemNumber) {
        boolean result = false;
        int num = 1;
        for (MenuItem curItem : this) {
            if (num++ == itemNumber) {
                result = curItem.doAction();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MenuOutput cOut = new ConsoleOutput();
        MenuInput cIn = new ConsoleInput();
        Menu menu = new Menu(cOut, cIn);
        MenuItemTask1 task1 = new MenuItemTask1(menu.getRoot(), "Task 1.", cOut);
        MenuItemTask1_1 task1_1 = new MenuItemTask1_1(task1, "---- Task 1.1.", cOut);
        MenuItemTask1_1_1 task1_1_1 = new MenuItemTask1_1_1(task1_1, "-------- Task 1.1.1.", cOut);
        MenuItemTask1_1_2 task1_1_2 = new MenuItemTask1_1_2(task1_1, "-------- Task 1.1.2.", cOut);
        MenuItemTask1_2 task1_2 = new MenuItemTask1_2(task1, "---- Task 1.2.", cOut);
        menu.showMenu();
        int selected = menu.selectItem("Enter number (1-5):");
        menu.doActionByItemNumber(selected);
    }

}
