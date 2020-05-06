package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        Node<T> node = new Node<>(value, null, tail);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
    }

    public T deleteLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        T result = tail.value;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
          tail.next = null;
        }
        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
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
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}