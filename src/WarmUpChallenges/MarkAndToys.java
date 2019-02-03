package WarmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-02-03.
 */
public class MarkAndToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int count = 0;
        int startIndex = 0;
        while (k >= 0) {
            int min = prices[startIndex];
            int minI = startIndex;
            for (int i = startIndex; i < prices.length; i++) {
                if (min > prices[i]) {
                    min = prices[i];
                    minI = i;
                }
            }
            int temp = prices[startIndex];
            prices[startIndex] = min;
            prices[minI] = temp;

            startIndex++;
            if (k >= min) {
                count++;
            }
            k -= min;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
//        int[] a = new int[]{1, 12, 5, 111, 200, 1000, 10};
//        System.out.println(maximumToys(a, 50));
    }
}
