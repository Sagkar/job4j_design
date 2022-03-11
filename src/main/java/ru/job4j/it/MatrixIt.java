package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length) {
            row++;
            return row < data.length && column < data[row].length;
        }
        return row < data.length && column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
//        for (row = 0; row < data.length; row++) {
//            for (column = 0; column < data[row].length; column++) {
//                return data[row][column];
//            }
//        }
        return data[row][column++];
    }
}