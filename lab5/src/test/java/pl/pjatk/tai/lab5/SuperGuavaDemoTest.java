package pl.pjatk.tai.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuperGuavaDemoTest {

    private SuperGuavaDemo superGuavaDemo;

    @BeforeEach
    void setUp() {
        superGuavaDemo = new SuperGuavaDemo();
    }

    @Test
    void shouldReturnEmptyStringForNullParameter() {
        String input = null;

        String result = superGuavaDemo.transformString(input);

        Assertions.assertNotNull(result, "String cannot be null");
    }

    @Test
    void shouldReturnStringWithPrefixForNonNullParameter() {
        String input = "DUDUDU fesafe";

        String result = superGuavaDemo.transformString(input);

        Assertions.assertEquals(SuperGuavaDemo.PREFIX, result, "Must contain prefix");
    }

    @Test
    void shouldThrowExceptionWhenIllegalStringProvided() {
        String input = "1234";

        Assertions.assertThrows(IllegalArgumentException.class, () -> superGuavaDemo.transformString(input));
    }

}
