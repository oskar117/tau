package pl.pjatk.tai.lab5;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.MessageDigest;

public class SuperCommonsDemoTest {

    private SuperCommonsDemo superCommonsDemo;

    @BeforeEach
    void setUp() {
        superCommonsDemo = new SuperCommonsDemo();
    }

    @Test
    void shouldHashMessageWithProperAlgorithm() {
        String input = "test";
        String expected = "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08";

        String result = superCommonsDemo.hashMessage(input, DigestUtils.getSha256Digest());

        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldReturnWrongDigestFromWrongAlgorithm() {
        String input = "test";
        String expected = "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08";

        String result = superCommonsDemo.hashMessage(input, DigestUtils.getMd2Digest());

        Assertions.assertNotEquals(expected, result);
    }

    @Test
    void shouldReturnDifferentDigestIfOneLetterChanges() {
        String input = "test1";
        String expected = "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08";

        String result = superCommonsDemo.hashMessage(input, DigestUtils.getSha256Digest());

        Assertions.assertNotEquals(expected, result);
    }

    @Test
    void shouldNotMatchDigestFromTwoAlgorithms() {
        String input = "test";

        String result1 = superCommonsDemo.hashMessage(input, DigestUtils.getSha256Digest());
        String result2 = superCommonsDemo.hashMessage(input, DigestUtils.getMd5Digest());

        Assertions.assertNotEquals(result1, result2);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNullInput() {
        String input = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> superCommonsDemo.hashMessage(input, DigestUtils.getSha256Digest()));
    }

    @Test
    void shouldThrowNullPointerExceptionIfAlgorithmIsNull() {
        String input = "test";
        MessageDigest algorithm = null;

        Assertions.assertThrows(NullPointerException.class, () -> superCommonsDemo.hashMessage(input, algorithm));
    }

    @Test
    void shouldReturnProperInstance() {
        String input = "test";

        String result = superCommonsDemo.hashMessage(input, DigestUtils.getSha256Digest());

        Assertions.assertInstanceOf(String.class, result);
    }
}
