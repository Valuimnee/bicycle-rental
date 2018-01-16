package com.tsalapova.bicyclerental.generator;

import javafx.util.Pair;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.SCrypt;
import org.bouncycastle.crypto.prng.DigestRandomGenerator;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/1/2017
 */
public class HashGenerator {
    private static DigestRandomGenerator drg = new DigestRandomGenerator(new SHA256Digest());
    private static final int LENGTH = 40;

    public Pair<String, String> generateHashSalt(String input) {
        String salt = nextSalt(LENGTH);
        String result = generateHash(input, salt);
        return new Pair<>(result, salt);
    }

    public String generateHash(String input, String salt) {
        return DatatypeConverter.printHexBinary(SCrypt.generate(input.getBytes(), salt.getBytes(),
                16834, 8, 1, LENGTH / 2)).toLowerCase();
    }

    private String nextSalt(int length) {
        drg.addSeedMaterial(new SecureRandom().generateSeed(length / 2));
        byte[] bytes = new byte[length / 2];
        drg.nextBytes(bytes);
        return DatatypeConverter.printHexBinary(bytes).toLowerCase();
    }

}
