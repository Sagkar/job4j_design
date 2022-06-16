package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E> {

    Node<E> head = new Node<E>(null, null);

    private int size = 0;

    private int modCount = 0;

    private Node<E> next;

    @Override
    public void add(E value) {
        Node<E> temp = next;
        Node<E> node = new Node<E>(value, null);
        next = node;
        if (temp == null) {
            head = next;
        } else {
            temp.nextEl = node;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl = head;
        for (int i = 0; i < index; i++) {
            rsl = rsl.nextEl;
        }
        return rsl.item;
    }

    private static class Node<E> {
        E item;
        Node<E> nextEl;

        Node(E element, Node<E> next) {
            this.item = element;
            this.nextEl = next;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "item=" + item
                    + ", nextEl=" + nextEl
                    + '}';
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            Node<E> itNode = head;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (itNode == null) {
                    return false;
                }
                return itNode.item != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E currentEl = itNode.item;
                itNode = itNode.nextEl;
                return currentEl;
            }
        };
    }
}
