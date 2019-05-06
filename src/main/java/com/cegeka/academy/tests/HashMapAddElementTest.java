package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.MaxEntriesException;
import com.cegeka.academy.exceptions.NullKeyException;
import com.cegeka.academy.exceptions.NullValueException;
import com.cegeka.academy.util.HashMap;
import com.cegeka.academy.util.KeyObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashMapAddElementTest {
    @Test
    public void GIVEN_hashMap_WHEN_addOneElement_THEN_EntriesEqualOne() throws MaxEntriesException, NullKeyException, NullValueException {
        HashMap<KeyObject, String> hashMap = new HashMap<>();
        int expectedEntries = 1;
        hashMap.addElement(new KeyObject("Key1",2), "First String");
        assertEquals("Check entries", expectedEntries, hashMap.getEntries());
    }

    @Test
    public void GIVEN_hashMap_WHEN_addMaxNumberOfElementsWithoutReinitialization_THEN_SizeFactorRemainsTheSame() throws MaxEntriesException, NullKeyException, NullValueException {
        HashMap<KeyObject, String> hashMap = new HashMap<>();
        for(int i = 0; i < (1 << 3) * 2; i++)
        {
            hashMap.addElement(new KeyObject("Key" + i,2), "First String");
        }
        int expectedEntries = (1 << 3) * 2;
        int expectedSizeFactor = 3;
        assertEquals("Test max entries without reinitialization", expectedEntries, hashMap.getEntries());
        assertEquals("Test same sizeFactor", expectedSizeFactor, hashMap.getSizeFactor());
    }

    @Test
    public void GIVEN_hashMap_WHEN_addMinNumberOfElementsForReinitialization_THEN_SizeFactorGrowsWithOne() throws MaxEntriesException, NullKeyException, NullValueException {
        HashMap<KeyObject, String> hashMap = new HashMap<>();
        for(int i = 0; i <= (1 << 3) *2; i++)
        {
            hashMap.addElement(new KeyObject("Key" + i,2), "First String");
        }
        int expectedEntries = (1 << 3) * 2 + 1;
        int expectedSizeFactor = 4;
        assertEquals("Test max entries with reinitialization", expectedEntries, hashMap.getEntries());
        assertEquals("Test next sizeFactor", expectedSizeFactor, hashMap.getSizeFactor());
    }

    @Test(expected = MaxEntriesException.class)
    public void GIVEN_hashMap_WHEN_entriesAreMaxInt_THEN_MaxEntriesException() throws MaxEntriesException, NullKeyException, NullValueException {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.setEntries(Integer.MAX_VALUE, "TEST" );
        hashMap.addElement(3, "FS");
    }

    @Test(expected = NullKeyException.class)
    public void GIVEN_hashMap_WHEN_nullKey_THEN_nullKeyException() throws NullValueException, MaxEntriesException, NullKeyException {
        HashMap<KeyObject, String> hashMap = new HashMap<>();
        int expectedEntries = 1;
        hashMap.addElement(null, "First String");
        assertEquals("Check entries", expectedEntries, hashMap.getEntries());
    }

    @Test(expected = NullValueException.class)
    public void GIVEN_hashMap_WHEN_nullValue_THEN_nullValueException() throws NullValueException, MaxEntriesException, NullKeyException {
        HashMap<KeyObject, String> hashMap = new HashMap<>();
        int expectedEntries = 1;
        hashMap.addElement(new KeyObject("Key1",2), null);
        assertEquals("Check entries", expectedEntries, hashMap.getEntries());
    }

}
