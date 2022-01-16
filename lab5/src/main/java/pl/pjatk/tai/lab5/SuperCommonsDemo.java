package pl.pjatk.tai.lab5;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

public class SuperCommonsDemo {

    String hashMessage(String s, MessageDigest digest) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (digest.getAlgorithm().equals("SHA-256")) {
            return DigestUtils.sha256Hex(s);
        } else {
            return DigestUtils.md5Hex(s);
        }
    }

    public static void main(String[] args) {
        SuperCommonsDemo commonsDemo = new SuperCommonsDemo();
        System.out.println(commonsDemo.hashMessage("dd", null));
    }
}
