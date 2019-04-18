package com.cegeka.academy.testing;

import com.cegeka.academy.classes.hashmap.MyEntry;
import com.cegeka.academy.classes.hashmap.MyHashMap;
import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {

    @Test
    public void GIVEN_hashmapRightValues_WHEN_putAndGet_THEN_returnCorrect() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>(2);
        map.put(20, 1);
        map.put(20, 2);
        Assert.assertEquals(2, map.get(20), 0.01d);
    }

    @Test
    public void GIVEN_hashmapRightValues_WHEN_remove_THEN_returnCorrect() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>(2);
        map.put(20, 1);
        boolean result = map.remove(20);
        Assert.assertNull(map.get(20));
        Assert.assertTrue(result);
    }

    @Test
    public void GIVEN_hashmapRightValues_WHEN_containsKey_THEN_returnCorrect() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>(2);
        map.put(20, 1);
        Assert.assertTrue(map.containsKey(20));
    }

    @Test
    public void GIVEN_hashmapRightValues_WHEN_containsValue_THEN_returnCorrect() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>(3);
        map.put(20, 1);
        map.put(21, 3);
        map.put(22, 5);
        Assert.assertTrue(map.containsValue(5));
    }

    @Test
    public void GIVEN_hashmapRightValues_WHEN_entrySet_THEN_returnCorrect() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>(3);
        MyEntry[] entries = new MyEntry[3];
        for (int i = 0; i < 3; i++) {
            entries[i] = new MyEntry<>(i, 30, null);
            map.put(i, 30);
        }

        MyEntry[] entriesTest = map.entrySet();

        Assert.assertArrayEquals(entries, entriesTest);
    }
}
