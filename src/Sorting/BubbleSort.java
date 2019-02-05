package Sorting;

import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-02-03.
 */
public class BubbleSort {

    // Complete the countSwaps function below.
    private static void countSwaps(int[] a) {
        int count = 0;
        int lastSorted = a.length - 1;
        while (lastSorted >= 0) {
            for (int i = 0; i < lastSorted; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    count++;
                }
            }
            lastSorted--;
        }
        System.out.println("Array is sorted in " + count + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
//        int[] a = {3, 2, 1};
//        countSwaps(a);
    }
}
