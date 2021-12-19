package pl.pjatk.tai.lab4;

import java.util.Arrays;

class Calculator {

    int divide(int a, int b) {
        return a / b;
    }

    int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
