package com.cegeka.academy.util;

public class HashNode<T,H> {
    private T key;
    private H data;
    private HashNode<T,H> nextSibling;

    public HashNode(T key, H data) {
        this.key = key;
        this.data = data;
        this.nextSibling = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public H getData() {
        return data;
    }

    public void setData(H data) {
        this.data = data;
    }

    public HashNode<T,H> getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(HashNode<T,H> nextSibling) {
        this.nextSibling = nextSibling;
    }
}
