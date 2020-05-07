package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<T> implements Iterable<T> {

    private SimpleLinkedList.Node<T> head;
    private int size = 0;
    private SimpleLinkedList.Node<T> cursor;
    private int currentPosition = 0;
    private long modCount = 0;

    public void add(T value) {
        size++;
        modCount++;
        SimpleLinkedList.Node<T> node = new SimpleLinkedList.Node<>(value, null);
        if (head == null) {
            head = node;
            cursor = head;
            return;
        }
        SimpleLinkedList.Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        if (currentPosition > index) {
            currentPosition = 0;
            cursor = head;
        }
        for (int i = currentPosition; i < index; i++) {
            cursor = cursor.next;
        }
        currentPosition = index;
        return cursor.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            SimpleLinkedList.Node<T> node = head;
            long expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        SimpleLinkedList.Node<T> next;

        public Node(T value, SimpleLinkedList.Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

}
