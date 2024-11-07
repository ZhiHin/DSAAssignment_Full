/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adt;

import entity.TutorialGroup;
import java.util.Objects;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tkair
 */
public class HashMap<K, V> implements HashMapInterface<K, V> {

    Node<K, V>[] hashTable;
    private static final int DEFAULT_TABLE_SIZE = 8;
    private int numberOfEntries = 0;
    private static final double MAX_LOAD_FACTOR = 0.8;

    public HashMap() {
        hashTable = new Node[DEFAULT_TABLE_SIZE];
        numberOfEntries = 0;
    }

    public HashMap(int tableSize) {
        int primeSize = getNextPrime(tableSize);
        hashTable = new Node[primeSize];
        numberOfEntries = 0;
    }

    @Override
    public boolean add(K key, V value) {
        int index = getHashIndex(key);

        if (isHashTableTooFull()) {
            rehash();
        }

        if (hashTable[index] == null) {
            hashTable[index] = new Node(key, value);
            numberOfEntries++;

            return true;
        } else if (hashTable[index] != null && !hashTable[index].key.equals(key)) {
            Node currentNode = hashTable[index];
            Node nodeBefore = currentNode.next;

            while ((currentNode != null) && !key.equals(currentNode.key)) {
                nodeBefore = currentNode;
                currentNode = currentNode.next;
            }

            if (currentNode == null) {
                // key not in chain; add new entry to end of chain
                Node<K, V> newNode = new Node<K, V>(key, value);
                nodeBefore.next = newNode; // Corrected this line
                numberOfEntries++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

//    public void addAll(HashMap<K, V> hashMapGiven) {
//        for (Entry<K, V> entry : hashMapGiven.getEntries()) {
//            K key = entry.getKey();
//            V value = entry.getValue();
//            add(key, value); // Use your custom add method to add entries
//        }
//    }
    @Override
    public boolean remove(K key) {
        int index = getHashIndex(key);

        // search chain beginning at hashTable[index] for a node that contains key
        Node<K, V> nodeBefore = null;
        Node<K, V> currentNode = hashTable[index];

        while ((currentNode != null) && !key.equals(currentNode.key)) {
            nodeBefore = currentNode;
            currentNode = currentNode.next;
        } // end while

        if (currentNode != null) {
            if (nodeBefore == null) {
                // remove first node
                hashTable[index] = currentNode.next;
            } else {
                nodeBefore.next = currentNode.next;
            }

            numberOfEntries--;
            return true;
        }

        return false;

    }

    public boolean replace(K key, V valueReplaced) {
        int index = getHashIndex(key);

        // Search chain beginning at hashTable[index] for a node that contains key
        Node<K, V> currentNode = hashTable[index];

        while (currentNode != null && !key.equals(currentNode.key)) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            // Found the node with the given key; replace its value
            currentNode.value = valueReplaced;
            return true;
        }

        return false;
    }

    private void rehash() {
        Node<K, V>[] oldTable = hashTable;
        int oldSize = oldTable.length;
        int newSize = getNextPrime(oldSize + oldSize);

        hashTable = new Node[newSize];    // increase size of array

        numberOfEntries = 0; // reset number of dictionary entries, since

        for (int index = 0; index < oldSize; ++index) {

            Node<K, V> currentNode = oldTable[index];

            while (currentNode != null) { // skip empty lists

                add(currentNode.key, currentNode.value);

                currentNode = currentNode.next;
            }
        }
    }

    private boolean isHashTableTooFull() {
        return numberOfEntries > MAX_LOAD_FACTOR * hashTable.length;
    }

    private int getNextPrime(int integer) {
        if (integer % 2 == 0) {
            integer++;
        }

        while (!isPrime(integer)) {
            integer = integer + 2;
        }

        return integer;
    }

    private boolean isPrime(int integer) {
        boolean result;
        boolean done = false;

        if ((integer == 1) || (integer % 2 == 0)) {
            result = false;
        } else if ((integer == 2) || (integer == 3)) {
            result = true;
        } else {
            result = true; // assume prime
            for (int divisor = 3; !done && (divisor * divisor <= integer); divisor = divisor + 2) {
                if (integer % divisor == 0) {
                    result = false;
                    done = true;
                }
            }
        }

        return result;
    }

    public final void clear() {
        for (int index = 0; index < hashTable.length; index++) {
            hashTable[index] = null;
        }

        numberOfEntries = 0;
    }

    public int getSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean contains(K key) {
        return getValue(key) != null;
    }

    private int getHashIndex(K key) {
        int hashIndex = key.hashCode() % hashTable.length;
        if (hashIndex < 0) {
            hashIndex = hashIndex + hashTable.length;
        }
        return hashIndex;
    }

    @Override
    public V getValue(K key) {
        int index = getHashIndex(key);

        // search chain beginning at hashTable[index] for a node that contains key
        Node<K, V> nodeBefore = null;
        Node<K, V> currentNode = hashTable[index];

        while ((currentNode != null) && !key.equals(currentNode.key)) {
            nodeBefore = currentNode;
            currentNode = currentNode.next;
        } // end while

        if (currentNode != null) {
            return currentNode.value;
        }
        return null;

    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < hashTable.length; index++) {
            if (hashTable[index] != null) {
                Node<K, V> currentNode = hashTable[index];
                while (currentNode != null) {
                    outputStr += currentNode.value;
                    currentNode = currentNode.next;

                } // end while

            }
        }
        return outputStr;
    }

    public Iterator<Entry<K, V>> getIterator() {
        return new HashMapIterator();
    }

    @Override
    public Entry<K, V>[] getEntries() {
        Entry<K, V>[] entries = new Entry[numberOfEntries];
        int index = 0;

        for (Node<K, V> node : hashTable) {
            while (node != null) {
                entries[index++] = new Entry<>(node.key, node.value);
                node = node.next;
            }
        }

        return entries;
    }

    // Define an inner class that implements the Iterator interface
    private class HashMapIterator implements Iterator<Entry<K, V>> {

        private int index = 0;
        private Node<K, V> currentNode = null;

        @Override
        public boolean hasNext() {
            if (currentNode != null && currentNode.next != null) {
                return true;
            }

            while (index < hashTable.length && hashTable[index] == null) {
                index++;
            }

            if (index < hashTable.length) {
                currentNode = hashTable[index];
                return true;
            }

            return false;
        }

        @Override
        public Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node<K, V> entryToReturn = currentNode;
            currentNode = currentNode.next;

            return new Entry<>(entryToReturn.key, entryToReturn.value);
        }

    }

    // ... Other methods and members of your HashMap class ...
    // You can define an Entry class to wrap key-value pairs
    public static class Entry<K, V> {

        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private class Node<K, V> implements java.io.Serializable {

        private K key;
        private V value;
        private Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 17 * hash + Objects.hashCode(this.key);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node<?, ?> other = (Node<?, ?>) obj;
            return Objects.equals(this.key, other.key);
        }

    }
}
