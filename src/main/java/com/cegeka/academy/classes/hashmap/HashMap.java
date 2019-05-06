package com.cegeka.academy.classes.hashmap;

class HashMap<K, V> {
    private Entry[] entries;
    private int size;
    public HashMap(int size) {
        this.size = size;
        entries = new Entry[this.size];
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new RuntimeException("Nu se poate introduce cheie nula!");
        }
        int hashValue = generateHash(key);
        Entry<K, V> myEntry = new Entry<>(key, value, null);
        if (entries[hashValue] == null) {
            entries[hashValue] = myEntry;
        } else {

            Entry previous = null;
            Entry current = entries[hashValue];
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
            Entry temp = entries[hashValue];
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
            Entry previous = null;
            Entry current = entries[hashValue];
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
            Entry current = entries[hashValue];
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

        for (Entry myEntry : entries) {
            Entry current = myEntry;
            while (current != null) {
                if (current.value == value) {
                    return true;
                }
                current = current.next;
            }
        }


        return false;
    }

    public Entry[] entrySet() {
        return this.entries;
    }

    private int generateHash(K key) {
        return key.hashCode() % entries.length;
    }
}