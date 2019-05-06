package com.cegeka.academy.tests;

import com.cegeka.academy.util.HashMap;
import com.cegeka.academy.util.KeyObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HashMapConstructorTest {
    @Test
    public void GIVEN_hashMapClassWithKeyStringAndDataInteger_WHEN_callingConstructor_THEN_newCorrectObject()
    {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int expectedEntries = 0;
        int expectedSizeFactor = 3;

        assertEquals("Test entries", expectedEntries, hashMap.getEntries());
        assertEquals("Test expected size factor", expectedSizeFactor, hashMap.getSizeFactor());
        assertNotNull("Test bucket obj not null", hashMap.getBucketList());
    }

    @Test
    public void GIVEN_hashMapClassWithKeyKeyObjectAndDataString_WHEN_callingConstructor_THEN_newCorrectObject()
    {
        HashMap<KeyObject, String> hashMap = new HashMap<>();
        int expectedEntries = 0;
        int expectedSizeFactor = 3;

        assertEquals("Test entries", expectedEntries, hashMap.getEntries());
        assertEquals("Test expected size factor", expectedSizeFactor, hashMap.getSizeFactor());
        assertNotNull("Test bucket obj not null", hashMap.getBucketList());
    }
}
