package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

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
        items.add(item);
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
        return items.indexOf(new Item(id, ""));
    }

    public boolean replace(String id, Item item) {
        int indexOfItem =  getIndexById(id);
        boolean canBeReplaced = (indexOfItem != -1);
        if (canBeReplaced) {
            items.set(indexOfItem, item);
        }
        return canBeReplaced;
    }

    public boolean delete(String id) {
        int indexOfItem =  getIndexById(id);
        boolean canBeDeleted = (indexOfItem != -1);
        if (canBeDeleted) {
            items.remove(indexOfItem);
        }
        return (canBeDeleted);
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item curItem : items) {
            if (curItem.getName().equals(key)) {
                result.add(curItem);
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        int indexOfItem =  getIndexById(id);
        if (indexOfItem != -1) {
            result = items.get(indexOfItem);
        }
        return result;
    }
}
