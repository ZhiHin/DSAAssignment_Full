/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import entity.TutorialGroup;
import java.util.Iterator;

/**
 *
 * @author tkair
 */
public interface HashMapInterface<K, V> {

    public boolean add(K key, V value);

    public boolean remove(K key);

    public boolean replace(K key, V valueReplaced);

    public boolean isEmpty();

    public boolean contains(K key);
    
    public V getValue(K key);

    public int getSize();

    public Iterator getIterator();

    public HashMap.Entry<K, V>[] getEntries();
}
