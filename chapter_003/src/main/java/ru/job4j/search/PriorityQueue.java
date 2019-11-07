package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        boolean inserted = false;
        for (int index = 0; index < tasks.size(); index++) {
            if (task.getPriority() < tasks.iterator().next().getPriority()) {
                inserted = true;
                tasks.add(index, task);
                break;
            }
        }
        if (!inserted) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
