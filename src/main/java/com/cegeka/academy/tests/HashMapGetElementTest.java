package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.KeyNotFoundException;
import com.cegeka.academy.exceptions.MaxEntriesException;
import com.cegeka.academy.util.HashMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashMapGetElementTest {

    @Test
    public void GIVEN_hashMap_WHEN_addedElement_THEN_getTheSameElement() throws MaxEntriesException, KeyNotFoundException {
        HashMap<String,Integer> hashMap = new HashMap<>();
        int expected = 10;
        String key = "Casa";
        hashMap.addElement(key, expected);
        assertEquals("A gasit elementul", (int) expected, (int)hashMap.getElement(key));
    }

    @Test
    public void GIVEN_hashMap_WHEN_added1000Elements_THEN_getTheSameElements() throws MaxEntriesException, KeyNotFoundException {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < 1025; i++)
        {
            String key = "Casa" + i;
            hashMap.addElement(key, i);
        }

        for(int i = 0; i < 1025; i++)
        {
            String key = "Casa"+i;
            int actual = hashMap.getElement(key);
            assertEquals("Verificam daca primim toate elementele corect", i, actual );
        }
    }
}
