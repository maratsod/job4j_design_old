package ru.job4j.generics;

import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int point = 0;

    public SimpleArray(T[] data) {
        this.array = data;
    }

    public void add(T model) throws IndexOutOfBoundsException {
        array[Objects.checkIndex(point++, array.length)] = model;

    }

    public void set(int index, T model) throws IndexOutOfBoundsException {
        array[Objects.checkIndex(index, point)] = model;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        index = Objects.checkIndex(index, point);
        System.arraycopy(array, index + 1, array, index, point - index - 1);
        point--;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return array[Objects.checkIndex(index, array.length)];
    }

    @Override
    public Iterator<T> iterator()  {
        return new Iterator<T>() {
            int point = 0;

            @Override
            public boolean hasNext() {
                return point < array.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[point++];
            }
        };
    }
}
