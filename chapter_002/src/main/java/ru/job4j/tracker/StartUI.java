package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] allItems = tracker.findAll();
        for (Item currentItem : allItems) {
            if (currentItem != null) {
                System.out.println("Item: " + currentItem.getName() + " id = " + currentItem.getId());
            }
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        System.out.print("Enter the Id of item to edit: ");
        String itemId = input.askStr("");
        Item currentItem = tracker.findById(itemId);
        if (currentItem != null) {
            System.out.print("Enter new name: ");
            String name = input.askStr("");
            currentItem.setName(name);
            tracker.replace(itemId, currentItem);
        } else {
            System.out.print("Wrong Id!");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        System.out.print("Enter the Id of item to delete: ");
        String itemId = input.askStr("");
        if (!tracker.delete(itemId)) {
            System.out.print("Wrong Id!");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        System.out.print("Enter the Id of item to find: ");
        String itemId = input.askStr("");
        Item currentItem = tracker.findById(itemId);
        if (currentItem != null) {
            System.out.print("Found by Id: " + currentItem.getName());
        } else {
            System.out.print("Wrong Id!");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        System.out.print("Enter the Name of item to find: ");
        String itemName = input.askStr("");
        Item[] foundItems = tracker.findByName(itemName);
        if (foundItems != null) {
            for (Item currentItem : foundItems) {
                if (currentItem != null) {
                    System.out.println("Item: " + currentItem.getName() + " id = " + currentItem.getId());
                }
            }
        } else {
            System.out.print("Wrong Name!");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showAllItems(input, tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemsByName(input, tracker);
            } else if (select == 6) {
                System.out.println("good bye!");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
