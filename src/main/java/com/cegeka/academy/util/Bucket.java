package com.cegeka.academy.util;

public class Bucket<T,H> {
    private HashNode<T,H> firstNode;
    private Bucket<T,H> nextBucket;

    public Bucket() {
        this.firstNode = null;
        this.nextBucket = null;
    }

    public HashNode<T, H> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(HashNode<T, H> firstNode) {
        this.firstNode = firstNode;
    }

    public Bucket<T, H> getNextBucket() {
        return nextBucket;
    }

    public void setNextBucket(Bucket<T, H> nextBucket) {
        this.nextBucket = nextBucket;
    }
}
