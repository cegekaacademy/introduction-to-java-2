package com.cegeka.academy.testing;

import com.cegeka.academy.classes.hashmap.Entry;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class HasMapTest {

    @Test
    public void GIVEN_hashmapRightValues_WHEN_putAndGet_THEN_returnCorrect() {
        HashMap<Integer, Integer> map = new HashMap<>(3);
        map.put(30, 1);
        map.put(15, 2);
        map.put(25, 3);
        Assert.assertEquals(3, map.get(25), 0.01d);
    }

    @Test
    public void GIVEN_hashmapRightValues_WHEN_remove_THEN_returnCorrect() {
        HashMap<Integer, Integer> map = new HashMap<>(2);
        map.put(30, 1);
        boolean result = map.remove(30,1);
        Assert.assertNull(map.get(20));
        Assert.assertTrue(result);
    }

    @Test
    public void GIVEN_hashmapRightValues_WHEN_containsKey_THEN_returnCorrect() {
        HashMap<Integer, Integer> map = new HashMap<>(2);
        map.put(15, 1);
        Assert.assertTrue(map.containsKey(15));
    }

    @Test
    public void GIVEN_hashmapRightValues_WHEN_containsValue_THEN_returnCorrect() {
        HashMap<Integer, Integer> map = new HashMap<>(3);
        map.put(20, 1);
        map.put(21, 3);
        map.put(22, 5);
        Assert.assertTrue(map.containsValue(5));
    }

    @Test
    public void GIVEN_hashmapRightValues_WHEN_entrySet_THEN_returnCorrect() {
        HashMap<Integer, Integer> map = new HashMap<>(3);
        Entry[] entries = new Entry[3];
        for (int i = 0; i < 3; i++) {
            entries[i] = new Entry<>(i, 30, null);
            map.put(i, 30);
        }

        Entry[] entriesTest = entries;

        Assert.assertArrayEquals(entries, entriesTest);
    }
}
