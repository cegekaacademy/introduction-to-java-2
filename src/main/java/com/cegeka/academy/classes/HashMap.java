package com.cegeka.academy.classes;

public class HashMap<K, O> {

    private EntrySet[] entrySets;
    private int size;

    public HashMap(int size) {
        this.size = size;
    }

    public int determineHashCode(K key) {
        return key.hashCode() % this.entrySets.length;
    }

    public void put(K key, O object) throws Exception {
        if (key == null) {
            throw new Exception("Cheia trebuie sa aiba o valoare");
        }

        if (object == null) {
            throw new Exception("Obiectul trebuie sa existe");
        }

        int hashCode = determineHashCode(key);

        EntrySet<K, O> entrySet = new EntrySet<>(key, object, null);
        if (entrySets[hashCode] == null) {
            entrySets[hashCode] = entrySet;
        } else {
            EntrySet current = entrySets[hashCode];
            while (current != null) {
                if (current.next == null) {
                    current.next = entrySet;
                    current = current.next;
                } else {
                    current = current.next;
                }
            }
        }
    }

    public O get(K key) throws Exception {
        if (key == null) {
            throw new Exception("Cheia trebuie sa aiba o valoare");
        }

        if(entrySets == null) {
            throw new Exception("Nu exista seturi de date inregistrate");
        }

        int hashCode = determineHashCode(key);

        if (entrySets[hashCode] == null) {
            throw new Exception("Nu s-a gasit niciun obiect cu aceasta cheie");
        } else {
            EntrySet current = entrySets[hashCode];
            while(current != null)
            if (current.key.equals(key)) {
                return (O) current;
            } else {
                current = current.next;
            }
        }

        throw new Exception("Nu s-a gasit niciun obiect cu aceasta cheie");
    }

    public void remove(K key) throws Exception {
        if(key == null) {
            throw new Exception("Cheia trebuie sa aiba o valoare");
        }

        if(entrySets == null) {
            throw new Exception("Nu exista seturi de date inregistrate");
        }

        int hashCode = determineHashCode(key);

        if(entrySets[hashCode] == null) {
            throw new Exception("Nu s-a gasit niciun obiect cu aceasta cheie");
        } else {
            EntrySet current = entrySets[hashCode];
            while(current != null) {
                if(current.next.key.equals(key)) {
                    EntrySet deleteEntry = current.next;
                    deleteEntry = null;
                    current.next = current.next.next;
                }
                current = current.next;
            }
        }
    }

    public boolean containsKey(K key) throws Exception {
        if(key == null) {
            throw new Exception("Cheia trebuie sa aiba o valoare");
        }

        if(entrySets == null) {
            throw new Exception("Nu exista seturi de date inregistrate");
        }

        int hashCode = determineHashCode(key);

        if(entrySets[hashCode] == null) {
            throw new Exception("Nu s-a gasit niciun obiect cu aceasta cheie");
        } else {
            EntrySet current = entrySets[hashCode];
            while(current != null) {
                if(current.key.equals(key)) {
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }

    public boolean containsValue(O value) throws Exception {
        if(value == null) {
            throw new Exception("Obiectul nu trebuie sa fie null");
        }

        if(entrySets == null) {
            throw new Exception("Nu exista seturi de date inregistrate");
        }

        for(EntrySet entrySet : entrySets) {
            EntrySet current = entrySet;
            while(current != null) {
                if(current.object.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }
}
