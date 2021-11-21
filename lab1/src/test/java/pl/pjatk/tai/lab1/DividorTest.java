package pl.pjatk.tai.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DividorTest {

    private final Calculator sum = new Calculator();

    @Test
    void shouldDivideTwoNumbers() {
        int result = sum.divide(15, 3);
        Assertions.assertEquals(5, result);
    }

    @Test
    void shouldThrowExceptionWhenDividingWith0() {
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> sum.divide(15, 0));
    }

    @Test
    void shouldSumArrayContent() {
        int[] input = {2, 1, 3, 7};
        int result = sum.sum(input);
        Assertions.assertEquals(13, result);
    }
}
