package ru.job4j.collection;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree<E> {

    private final Node<E> root;

    abstract class Checker {
        private E value;
        abstract boolean checkElement(Node<E> el);
        public Checker(E value) {
            this.value = value;
        }
    }

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isPresent() && findBy(child).isEmpty()) {
            rsl = true;
            parentNode.get().children.add(new Node<>(child));
        }
        return rsl;
    }

    public Optional<Node<E>> loop(Checker checker) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (checker.checkElement(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public boolean isBinary() {
        Checker curChecker = new Checker(null) {
            @Override
            boolean checkElement(Node<E> el) {
                return (el.children.size() > 2);
            }
        };
        return loop(curChecker).isEmpty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Checker curChecker = new Checker(value) {
            @Override
            boolean checkElement(Node<E> el) {
                return (el.value.equals(value));
            }
        };
        return loop(curChecker);
    }

}
