package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        int select;
        while (run) {
            this.showMenu(actions);
            do {
                select = input.askInt("Select: ");
            } while (select < 0 || select >= actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllAction(),
                new EditAction(),
                new DeleteAction(),
                new FindItemByIdAction(),
                new FindItemsByNameAction(),
                new QuitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
