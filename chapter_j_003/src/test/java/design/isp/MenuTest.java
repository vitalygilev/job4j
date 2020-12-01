package design.isp;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {

    @Test
    public void whenThirdItemSelected() {

        StubOutput cOut = new StubOutput();
        StubInput cIn = new StubInput();
        Menu menu = new Menu(cOut, cIn);
        MenuItemTask1 task1 = new MenuItemTask1(menu.getRoot(), "Task 1.", cOut);
        MenuItemTask1_1 task1_1 = new MenuItemTask1_1(task1, "---- Task 1.1.", cOut);
        MenuItemTask1_1_1 task1_1_1 = new MenuItemTask1_1_1(task1_1, "-------- Task 1.1.1.", cOut);
        MenuItemTask1_1_2 task1_1_2 = new MenuItemTask1_1_2(task1_1, "-------- Task 1.1.2.", cOut);
        MenuItemTask1_2 task1_2 = new MenuItemTask1_2(task1, "---- Task 1.2.", cOut);
        menu.showMenu();
        int selected = menu.selectItem("3");
        menu.doActionByItemNumber(selected);
        String current = String.join("", cOut.getLogOutput());
        String expect = "1) Task 1.2) ---- Task 1.1.3) -------- Task 1.1.1.4) -------- Task 1.1.2.5) ---- Task 1.2.This is a Task's 1.1.1 action!";
        assertThat(current, is(expect));
    }

}