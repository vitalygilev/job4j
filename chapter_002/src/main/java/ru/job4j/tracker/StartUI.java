package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] allItems = tracker.findAll();
                for (Item currentItem : allItems) {
                    if (currentItem != null) {
                        System.out.println("Item: " + currentItem.getName() + " id = " + currentItem.getId());
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter the Id of item to edit: ");
                String itemId = scanner.nextLine();
                Item currentItem = tracker.findById(itemId);
                if (currentItem != null) {
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    currentItem.setName(name);
                    tracker.replace(itemId, currentItem);
                } else {
                    System.out.print("Wrong Id!");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter the Id of item to delete: ");
                String itemId = scanner.nextLine();
                if (!tracker.delete(itemId)) {
                    System.out.print("Wrong Id!");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter the Id of item to find: ");
                String itemId = scanner.nextLine();
                Item currentItem = tracker.findById(itemId);
                if (currentItem != null) {
                    System.out.print("Found by Id: " + currentItem.getName());
                } else {
                    System.out.print("Wrong Id!");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter the Name of item to find: ");
                String itemName = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
