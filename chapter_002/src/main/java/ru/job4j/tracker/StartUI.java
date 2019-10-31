package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        int select;
        while (run) {
            this.showMenu(actions);
            select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(actions[index].info());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(0),
                new ShowAllAction(1),
                new EditAction(2),
                new DeleteAction(3),
                new FindItemByIdAction(4),
                new FindItemsByNameAction(5),
                new QuitAction(6)
        };
        new StartUI().init(validate, tracker, actions);
    }
}
