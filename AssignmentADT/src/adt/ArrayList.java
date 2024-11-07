package adt;

import entity.Tutor;
import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author zhinf
 */
public class ArrayList<T> implements ListInterface<T>, Serializable {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Object[initialCapacity];
        //array = (T[]) new Comparable[initialCapacity];
    }

    @Override
    public boolean add(T newEntry) {
        if (isArrayFull()) {
            doubleArray();
        }

        int index = 0;
        while (index < numberOfEntries && ((Tutor) newEntry).compareTo((Tutor) array[index]) > 0) {
            index++;
        }

        for (int i = numberOfEntries; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = newEntry;
        numberOfEntries++;

        return true;
    }


    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            if (isArrayFull()) {
                doubleArray();
            }
            makeRoom(newPosition);
            array[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];

            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }

            numberOfEntries--;
        }

        return result;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
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

    @Override
    public T find(T criteria) {
        T found = null;
        for (int index = 0; (index < numberOfEntries); index++) {
            if (criteria.equals(array[index])) {
                found = array[index];
            }
        }
        return null;
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
        return false;
    }

    private void doubleArray() {
        T[] oldArray = array;
        array = (T[]) new Object[oldArray.length * 2];
        //array = (T[]) new Comparable[oldArray.length * 2];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }

    private boolean isArrayFull() {
        return numberOfEntries == array.length;
    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }

        return outputStr;
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public Iterator<T> getIterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < numberOfEntries;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return array[currentIndex++];
            }
            return null;
        }

    }

}
