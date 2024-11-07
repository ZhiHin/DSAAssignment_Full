/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import adt.*;
import java.io.Serializable;

/**
 *
 * @author Dickie Wong Wei Hao
 */
public class SortedArrayList<T extends Comparable<T>> implements SortedArrayListInterface<T>, Serializable {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_ARRAYSIZE = 25;

    public SortedArrayList() {
        this(DEFAULT_ARRAYSIZE);
    }

    public SortedArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Comparable[initialCapacity];
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            doubleArray();
        }
        int i = 0;
        while (i < numberOfEntries && newEntry.compareTo(array[i]) > 0) {
            i++;
        }
        shiftUp(i + 1);
        array[i] = newEntry;
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];

            if (givenPosition < numberOfEntries) {
                shiftDown(givenPosition);
            }

            numberOfEntries--;
        }

        return result;
    }

    @Override
    public T remove(T entry) {
        if (!isEmpty()) {
            for (int i = 0; i < numberOfEntries; i++) {
                if (array[i].equals(entry)) {
                    removeGap(i + 1);
                    return array[i];
                }
            }
        }
        return null;
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
        array[--numberOfEntries] = null;
    }

    @Override
    public boolean find(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            array[givenPosition - 1] = newEntry;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];
        }

        return result;
    }

    private void shiftUp(int startIndex) {
        for (int i = numberOfEntries - 1; i >= startIndex - 1; i--) {
            array[i + 1] = array[i];
        }
    }

    private void shiftDown(int givenPosition) {
        // move each entry to next lower position starting at entry after the
        // one removed and continuing until end of array
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (array[i] != null && array[i].equals(element)) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    private void doubleArray() {
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Comparable[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == array.length;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int i = 0; i < numberOfEntries; ++i) {
            outputStr += array[i];
        }

        return outputStr;
    }

    @Override
    public T getEntry2(int givenPosition) {
        return array[givenPosition];
    }
}
