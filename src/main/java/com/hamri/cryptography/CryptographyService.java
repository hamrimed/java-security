package com.hamri.cryptography;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptographyService {
    private String messageDigestAlgorithm = "SHA-256";
    private MessageDigest messageDigestInstance = MessageDigest.getInstance(messageDigestAlgorithm);

    public CryptographyService() throws NoSuchAlgorithmException {
    }

    public byte[] getMessageDigest(String message) {
        return messageDigestInstance.digest(message.getBytes(StandardCharsets.UTF_8));
    }
}
