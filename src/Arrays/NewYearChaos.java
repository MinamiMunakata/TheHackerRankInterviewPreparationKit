package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-10-06.
 */
public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int count = 0;
        int j;
        for (int i = 0; i < q.length; i++) {
            if (q[i] > i + 1) {
                if (Math.abs(q[i] - (i + 1)) > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
                j = i;
                while (j < q.length - 2 && q[j] > q[j + 1]) {
                    swap(q, j, j + 1);
                    count++;
                    j++;
                }
            }
            if (q[i] <= i + 1) {
                j = i;
                while (j > 0 && q[j - 1] > q[j]) {
                    swap(q, j - 1, j);
                    count++;
                    j--;
                }
            }
        }
        System.out.println(count);
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
