package Arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-09-29.
 */
public class MinimumSwaps2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int p = -1;
        int i = 0;
        int count = 0;
        while (i < arr.length) {
            System.out.println(Arrays.toString(arr));
            if (p > -1) {
                if (arr[i] == p + 1) {
                    swap(arr, p, i);
                    count++;
                    i = p + 1;
                    p = -1;
                } else {
                    i++;
                }
            } else {
                if (arr[i] != i + 1) {
                    p = i;
                }
                i++;
            }
        }
        return count;

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
        System.out.println(res);
    }
}
