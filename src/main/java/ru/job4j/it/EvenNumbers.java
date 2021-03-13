package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbers implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumbers(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        point = point != -1 ? find() : -1;
        return point != -1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

    private int find() {
        for (int i = point; i < data.length; i++) {
            if (data[i] % 2 == 0) {
               return i;
            }
        }
        return -1;
    }

}
