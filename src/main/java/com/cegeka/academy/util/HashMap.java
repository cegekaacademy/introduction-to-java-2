package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.KeyNotFoundException;
import com.cegeka.academy.exceptions.MaxEntriesException;
import com.cegeka.academy.exceptions.NullKeyException;
import com.cegeka.academy.exceptions.NullValueException;

public class HashMap<T,H> {
    int sizeFactor;
    int entries;
    Bucket<T,H>  bucketList;

    public HashMap() {
        this.entries = 0;
        this.sizeFactor = 3;
        this.bucketList = new Bucket<>();
        int nrBucket = 1;
        Bucket<T,H> lastBucket = bucketList;

        while(nrBucket < ((1 << sizeFactor)))
        {
            lastBucket.setNextBucket(new Bucket<>());
            lastBucket = lastBucket.getNextBucket();
            nrBucket++;
        }

    }

    public void addElement(T key, H value) throws MaxEntriesException, NullValueException, NullKeyException {

        if(key == null)
            throw new NullKeyException();

        if(value == null)
            throw new NullValueException();

        if(this.entries == Integer.MAX_VALUE)
            throw new MaxEntriesException();

        if(this.entries == (1 << sizeFactor) * 2 )
        {
                ReinitializeHashMap(this.bucketList, this.sizeFactor, this.entries);
                this.addElement(key, value);
        }
        else
        {
            int index;
            index = key.hashCode() % (1 << sizeFactor);
            int count = 0;
            Bucket<T, H> bucket = bucketList;
            while(count < index && bucket.getNextBucket() != null)
            {
                bucket = bucket.getNextBucket();
                count++;
            }
            HashNode<T, H> node = bucket.getFirstNode();
            if(node != null) {
                while (node.getNextSibling() != null) {
                    node = node.getNextSibling();
                }
                node.setNextSibling(new HashNode<>(key, value));
                entries++;
            }
            else
            {
                 bucket.setFirstNode(new HashNode<T,H>(key, value));
                 entries++;
            }
        }
    }


    public H getElement(T key) throws KeyNotFoundException, NullKeyException {

        if(key == null)
            throw new NullKeyException();

        int index;
        index = key.hashCode() % (1 << sizeFactor);
        int count = 0;
        Bucket<T, H> bucket = bucketList;
        while(count < index && bucket.getNextBucket() != null)
        {
            bucket = bucket.getNextBucket();
            count++;
        }
        HashNode<T, H> node = bucket.getFirstNode();
        if(node != null)
        {
            while (!node.getKey().equals(key) && node.getNextSibling() != null)
            {
                node = node.getNextSibling();
            }
            if(node.getKey().equals(key))
            {
                return node.getData();
            }
            else
            {
                throw new KeyNotFoundException();
            }
        }
        else throw new KeyNotFoundException();
    }



    public void removeElement(T key) throws KeyNotFoundException, NullKeyException {

        if(key == null)
            throw new NullKeyException();

        int index;
        index = key.hashCode() % (1 << sizeFactor);
        int count = 0;
        Bucket<T, H> bucket = bucketList;
        while(count < index && bucket.getNextBucket() != null)
        {
            bucket = bucket.getNextBucket();
            count++;
        }
        HashNode<T, H> node = bucket.getFirstNode();
        if(node != null)
        {
            HashNode<T,H> lastNode = null;
            while (!node.getKey().equals(key) && node.getNextSibling() != null)
            {
                lastNode = node;
                node = node.getNextSibling();
            }
            if(node == bucket.getFirstNode())
            {
                if(node.getNextSibling()!=null)
                    bucket.setFirstNode(node.getNextSibling());
                else
                    bucket.setFirstNode(null);
                entries--;
            }
            else
                if(node.getKey().equals(key))
                {
                    lastNode.setNextSibling(node.getNextSibling());
                    this.entries--;
                }
                else
                {
                    throw new KeyNotFoundException();
                }
        }
        else
        {
            throw new KeyNotFoundException();
        }
    }

    private void ReinitializeHashMap(Bucket bucketList, int sizeFactor, int entries) throws MaxEntriesException, NullKeyException, NullValueException {
        this.entries = 0;
        this.sizeFactor = sizeFactor + 1;
        this.bucketList = new Bucket<>();
        int nrElement = 1;
        Bucket<T,H> lastBucket = this.bucketList;

        while(nrElement < ((1 << sizeFactor)))
        {
            lastBucket.setNextBucket(new Bucket<>());
            lastBucket = lastBucket.getNextBucket();
            nrElement++;
        }

        while(bucketList != null)
        {
            HashNode<T,H> element = bucketList.getFirstNode();
            while(element != null)
            {
                this.addElement(element.getKey(), element.getData());
                element = element.getNextSibling();
            }
            bucketList = bucketList.getNextBucket();
        }
    }

    public int getSizeFactor() {
        return sizeFactor;
    }

    public int getEntries() {
        return entries;
    }

    public Bucket<T, H> getBucketList() {
        return bucketList;
    }

    public void setEntries(int entries, String cod) {
        if(cod.equals("TEST")) {
            this.entries = entries;
        }
    }
}
