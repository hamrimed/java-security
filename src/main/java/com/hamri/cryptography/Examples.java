package com.hamri.cryptography;

import com.hamri.cryptography.examples.scripting.ScriptEngineName;
import com.hamri.cryptography.examples.scripting.ScriptService;

import java.security.NoSuchAlgorithmException;

public class Examples {
    private CryptographyService cryptograhyService;
    private ScriptService scriptService;
    Examples() {
        try {
            cryptograhyService = new CryptographyService();
        } catch (NoSuchAlgorithmException e) {
            print(e.getMessage());
        }
        if (cryptograhyService != null) {
            example01();
        }
        example02();
    }

    void example01() {
        print("############ example01: ");
        print(bytesToHex(cryptograhyService.getMessageDigest("hello world")));
        print("############");
    }

    void example02() {
        print("############ example02: ");
        scriptService = new ScriptService(ScriptEngineName.GROOVY);
        String groovyScript = "return Math.random();";
        print(scriptService.execute(groovyScript).toString());

        String groovyScript02 = "return Math.random();";
        print(scriptService.execute(groovyScript).toString());
        print("############");
    }

    public static void main(String[] args) {
        new Examples();
    }

    static void print(String object) {
        System.out.println(object);
    }
    static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }
}
