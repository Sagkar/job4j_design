package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean hn = false;
        while (index < data.length) {
            if (data[index] % 2 == 0) {
                hn = true;
                break;
            } else {
                index++;
            }
        }
        return hn;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
            return data[index++];
    }
}