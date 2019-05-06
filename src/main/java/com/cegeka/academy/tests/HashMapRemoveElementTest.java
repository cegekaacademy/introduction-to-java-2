package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.KeyNotFoundException;
import com.cegeka.academy.exceptions.MaxEntriesException;
import com.cegeka.academy.exceptions.NullKeyException;
import com.cegeka.academy.exceptions.NullValueException;
import com.cegeka.academy.util.HashMap;
import com.cegeka.academy.util.KeyObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashMapRemoveElementTest {
    @Test
    public void GIVEN_hashMap_WHEN_itemRemoved_EntriesDiminish() throws NullValueException, MaxEntriesException, NullKeyException, KeyNotFoundException {
        HashMap<KeyObject, String> hashMap = new HashMap<>();
        int expectedEntries = 0;
        KeyObject kob = new KeyObject("Key1",2);
        hashMap.addElement(kob, "First String");
        hashMap.removeElement(kob);
        assertEquals("Check entries", expectedEntries, hashMap.getEntries());
    }

    @Test
    public void GIVEN_hashMap_WHEN_added1000ElementsAndThenRemoved1000E_THEN_EntriesZero() throws MaxEntriesException, KeyNotFoundException, NullKeyException, NullValueException {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < 1025; i++)
        {
            String key = "Casa" + i;
            hashMap.addElement(key, i);
        }

        for(int i = 0; i < 1025; i++)
        {
            String key = "Casa"+i;
            hashMap.removeElement(key);
        }
        assertEquals("Verificam entries = 0", 0, hashMap.getEntries());
    }
}
