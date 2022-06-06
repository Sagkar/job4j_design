package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private E[] container;

    private int size = 0;

    private int modCount = 0;

    private Node<E> previous;

    private Node<E> next;

    public SimpleLinkedList() {
        this.container = (E[]) new Object[0];
    }

    @Override
    public void add(E value) {
        if (size == container.length) {
            increase();
        }
        Node<E> prev = next;
        Node<E> node = new Node<E>(prev, value, next);
        next = node;
        if (prev == null) {
            previous = node;
        } else {
            prev.nextEl = node;
        }
        container[size] = (E) node;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        final Node<E> l = (Node<E>) container[index];
        return l.item;
    }

    private static class Node<E> {
        E item;
        Node<E> nextEl;
        Node<E> prevEl;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.nextEl = next;
            this.prevEl = prev;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "item=" + item
                    + ", nextEl=" + nextEl
                    + ", prevEl=" + prevEl
                    + '}';
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int elNum = 0;
            Node<E> itNode = previous;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return elNum < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E currentEl = itNode.item;
                itNode = itNode.nextEl;
                elNum++;
                return currentEl;
            }
        };
    }

    private void increase() {
        container = Arrays.copyOf(container, (container.length + 1) * 2);
    }
}
