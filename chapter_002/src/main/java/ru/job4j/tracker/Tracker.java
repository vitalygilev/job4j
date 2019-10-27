package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int getIndexById(String id) {
        int result = -1;
        for (int index =0; index < items.length; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        int indexOfItem =  getIndexById(id);
        boolean canBeReplaced = (indexOfItem != -1);
        if (canBeReplaced) {
            items[indexOfItem].setId(item.getId());
            items[indexOfItem].setName(item.getName());
        }
        return canBeReplaced;
    }

    public boolean delete(String id) {
        int indexOfItem =  getIndexById(id);
        boolean canBeDeleted = (indexOfItem != -1);
        if (canBeDeleted) {
            items[indexOfItem] = null;
            for (int subIndex = indexOfItem; subIndex < items.length - 1; subIndex++) {
                if (items[subIndex + 1] != null) {
                    Item tmpItem = items[subIndex + 1];
                    items[subIndex + 1] = items[subIndex];
                    items[subIndex] = tmpItem;
                }
            }
        }
        return (canBeDeleted);
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int currentIndex = 0;
        for (Item current: items) {
            result[currentIndex++] = current;
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int currentIndex = 0;
        for (Item current: items) {
            if (current != null && current.getName().equals(key)) {
                result[currentIndex++] = current;
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item current: items) {
            if (current != null && current.getId().equals(id)) {
                result = current;
                break;
            }
        }
        return result;
    }
}
