/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author Dickie Wong Wei Hao
 */
public interface SortedArrayListInterface<T> {

    public boolean add(T newEntry);

    public T remove(int givenPosition);

    public T remove(T entry);

    public boolean find(T element);

    public boolean replace(int givenPosition, T newEntry);

    public T getEntry(int givenPosition);

    public T getEntry2(int givenPosition);

    int indexOf(T element);

    public boolean contains(T anEntry);

    public int getNumberOfEntries();

    public boolean isEmpty();

    public boolean isFull();

    public void clear();

}
