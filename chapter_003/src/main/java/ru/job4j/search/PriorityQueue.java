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
        var index = -1;
        for (var curTask : tasks) {
            index++;
            if (task.getPriority() < curTask.getPriority()) {
                tasks.add(index, task);
                break;
            }
        }
        if (index == tasks.size() - 1) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
