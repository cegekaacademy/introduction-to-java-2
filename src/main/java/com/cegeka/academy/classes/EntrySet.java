package com.cegeka.academy.classes;

import java.util.Objects;

public class EntrySet<K, O> {

    protected K key;
    protected O object;
    protected EntrySet next;

    public EntrySet(K key, O object, EntrySet<K, O> entrySet) {
        this.key = key;
        this.object = object;
        this.next = entrySet;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != getClass()) {
            return false;
        } else if(obj == this) {
            return true;
        } else {
            EntrySet<?, ?> entrySet = (EntrySet<?, ?>) obj;
            return Objects.equals(key, entrySet.key) && Objects.equals(object, entrySet.object);
        }
    }
}
