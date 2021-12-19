package pl.pjatk.tai.lab4;

import java.util.Arrays;

class BubbleSort {

     int[] sort(int[] in) {
        int n = in.length;
        int[] arr = Arrays.copyOf(in, n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

//         try {
//             TimeUnit.MILLISECONDS.sleep(4);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
        return arr;
    }
}
