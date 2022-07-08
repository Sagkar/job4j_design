package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int outCap = 0;
    int inCap = 0;

    public T poll() {
        if (outCap == 0 && inCap == 0) {
            throw new NoSuchElementException();
        }
        if (outCap == 0) {
            while (inCap > 0) {
                out.push(in.pop());
                outCap++;
                inCap--;
            }
        }
        outCap--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        inCap++;
    }
}