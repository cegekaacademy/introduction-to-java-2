package com.cegeka.academy.classes.hashmap;


public class MyHashMap<K, V> {
    private MyEntry[] entries;
    private int size;
    public MyHashMap(int size) {
        this.size = size;
        entries = new MyEntry[this.size];
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new RuntimeException("Nu se poate introduce cheie nula!");
        }
        int hashValue = generateHash(key);
        MyEntry<K, V> myEntry = new MyEntry<K, V>(key, value, null);
        if (entries[hashValue] == null) {
            entries[hashValue] = myEntry;
        } else {
            MyEntry previous = null;
            MyEntry current = entries[hashValue];
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        myEntry.next = current.next;
                        entries[hashValue] = myEntry;
                    } else {
                        myEntry.next = current.next;
                        previous.next = myEntry;
                    }
                }
                previous = current;
                current = current.next;
            }
            assert previous != null;
            previous.next = myEntry;
        }

    }


    public V get(K key) {
        if (key == null) {
            throw new RuntimeException("Nu se poate introduce cheie nula!");
        }
        int hashValue = generateHash(key);
        if (entries[hashValue] == null) {
            return null;
        } else {
            MyEntry temp = entries[hashValue];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return (V) temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public boolean remove(K key) {
        if (key == null) {
            throw new RuntimeException("Nu se poate introduce cheie nula!");
        }
        int hashValue = generateHash(key);
        if (entries[hashValue] == null) {
            return false;
        } else {
            MyEntry previous = null;
            MyEntry current = entries[hashValue];
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        entries[hashValue] = entries[hashValue].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    public boolean containsKey(K key) {
        int hashValue = generateHash(key);
        if (entries[hashValue] == null) {
            return false;
        } else {
            MyEntry current = entries[hashValue];
            while (current != null) {
                if (current.key.equals(key)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (value == null) {
            throw new RuntimeException("Nu se poate introduce valoarea nula!");
        }

        for (MyEntry myEntry : entries) {
            MyEntry current = myEntry;
            while (current != null) {
                if (current.value == value) {
                    return true;
                }
                current = current.next;
            }
        }


        return false;
    }

    public MyEntry[] entrySet() {
        return this.entries;
    }

    private int generateHash(K key) {
        return key.hashCode() % entries.length;
    }
}
