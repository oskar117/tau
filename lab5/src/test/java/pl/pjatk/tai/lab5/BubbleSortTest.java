package pl.pjatk.tai.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

class BubbleSortTest {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    void shouldReturnSameTypeAsInputType() {
        int[] input = {1, 2};
        Object result = bubbleSort.sort(input);
        Assertions.assertInstanceOf(int[].class, result);
    }

    @Test
    void shouldReturnEmptyArrayForEmptyInput() {
        int[] input = {};
        int[] result = bubbleSort.sort(input);
        Assertions.assertEquals(0, result.length);
    }

    @Test
    void shouldReturnSameNumberForOneElementInput() {
        int number = 5;

        int[] resultArr = bubbleSort.sort(new int[]{number});
        boolean result = resultArr[0] == 5;

        Assertions.assertTrue(result);
        Assertions.assertEquals(1, resultArr.length);
    }

    @Test
    void shouldAlwaysReturnSameNumbers() {
        int[] numbers = {2, 1, 3, 7};
        int[] result = bubbleSort.sort(numbers);

        Arrays.sort(numbers);
        int arraysEqual = Arrays.mismatch(numbers, result);

        Assertions.assertEquals(-1, arraysEqual);
    }

    @Test
    void shouldThrowExceptionWhenNullPassed() {
        Assertions.assertThrows(NullPointerException.class, () -> bubbleSort.sort(null));
    }

    @Test
    void shouldSortSimpleArray() {
        int[] input = {5, 2, 7, 9};
        int[] expected = {2, 5, 7, 9};
        int[] result = bubbleSort.sort(input);
        Assertions.assertArrayEquals(expected, result);
    }

    @RepeatedTest(10)
    void shouldSortSmallArraysFast() {
        Assertions.assertTimeout(Duration.ofMillis(5), () -> bubbleSort.sort(new int[] {4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 5, 6}));
    }

}
