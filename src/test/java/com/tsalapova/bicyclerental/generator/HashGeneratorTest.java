package com.tsalapova.bicyclerental.generator;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class HashGeneratorTest {

    @Test
    public void testGenerateHashSalt() {
        System.out.println(new HashGenerator().generateHashSalt("asdf1209gH"));
        Assert.assertTrue(true);
    }

    @Test
    public void testGenerateHash() {
        System.out.println(new HashGenerator().generateHash("3rQzdnXxeJCOlf8u", "b34009287ae1d3c7c0fddc8e48a3fe8e6349b053"));
        Assert.assertTrue(true);
    }
}