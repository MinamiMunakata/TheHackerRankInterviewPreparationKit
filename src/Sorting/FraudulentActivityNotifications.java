package Sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-02-06.
 */
public class FraudulentActivityNotifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        for (int i = d; i < expenditure.length; i++) {
            int[] trailing = new int[d];
            for (int j = d, k = 0; j > 0 && k < d; j--, k++) {
                trailing[k] = expenditure[i - j];
            }
            int median = 0;
            if (d % 2 == 0) {
                median = (trailing[d/2] + trailing[d/2 + 1])/2;
            } else {
                median = trailing[d/2];
            }
            System.out.println(median);
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nd = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nd[0]);
//
//        int d = Integer.parseInt(nd[1]);
//
//        int[] expenditure = new int[n];
//
//        String[] expenditureItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int expenditureItem = Integer.parseInt(expenditureItems[i]);
//            expenditure[i] = expenditureItem;
//        }
//
//        int result = activityNotifications(expenditure, d);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
        int[] expenditure = {10, 20, 30, 40, 50};

        System.out.println(activityNotifications(expenditure, 3));
    }
}
