package com.cegeka.academy.classes.hashmap;

import java.util.Objects;

public class MyEntry<K, V> {
    public K key;
    public V value;
    public MyEntry next;

    public MyEntry(K k, V v, MyEntry<K, V> next) {
        this.key = k;
        this.value = v;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEntry<?, ?> myEntry = (MyEntry<?, ?>) o;
        return Objects.equals(key, myEntry.key) &&
                Objects.equals(value, myEntry.value);
    }
}
