package com.cegeka.academy.classes.hashmap;

import java.util.Objects;

public class Entry<K, V> {
    public K key;
    public V value;
    public Entry next;

    public Entry(K k, V v, Entry<K, V> next) {
        this.key = k;
        this.value = v;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry<?, ?> myEntry = (Entry<?, ?>) o;
        return Objects.equals(key, myEntry.key) &&
                Objects.equals(value, myEntry.value);
    }
}