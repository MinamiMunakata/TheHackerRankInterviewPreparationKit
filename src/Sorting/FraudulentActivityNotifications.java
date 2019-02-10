package Sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-02-06.
 */
public class FraudulentActivityNotifications {
    private static final int MAX_EXPENDITURE = 200;

    // Complete the activityNotifications function below.
//    static int activityNotifications(int[] expenditure, int d) {
//        int count = 0, i = 0;
//        while (i < expenditure.length - d) {
//            int[] trailing = new int[d];
//            int j = 0;
//            while (j < d) {
//                trailing[j] = expenditure[i + j];
//                j++;
//            }
//            Arrays.sort(trailing);
//
//            if (expenditure[i + d] >= trailing[d / 2] * 2) {
//                count++;
//            }
//            i++;
//        }
//        return count;
//    }

    private static int activityNotifications(int[] expenditure, int d) {
        int notification = 0;
        int[] pastDDays = getPastDDaysHistory(expenditure, d);
        // Start at 'd'th expenditure till the end.
        for (int i = d; i < expenditure.length; i++) {
            int currentAmount = expenditure[i];
            double median = getMedian(d, pastDDays);
            // Count notification
            if (currentAmount >= median * 2) {
                notification++;
            }
            // Update past d days history.
            pastDDays[expenditure[i - d]] = pastDDays[expenditure[i - d]] - 1;
            pastDDays[expenditure[i]] = pastDDays[expenditure[i]] + 1;
        }

        return notification;
    }

    private static int[] getPastDDaysHistory(int[] expenditure, int d) {
        // Create expenditure history for past D days.
        int[] pastDDays = new int[MAX_EXPENDITURE + 1];
        for (int i = 0; i < d; i++) {
            pastDDays[expenditure[i]] = pastDDays[expenditure[i]] + 1;
        }
        return pastDDays;
    }


    private static double getMedian(int d, int[] pastDDays) {
        // Find a median
        double median = 0;
        int cursor = 0;
        int left = -1;
        int right;
        for (int amount = 0; amount <= MAX_EXPENDITURE; amount++) {
            cursor += pastDDays[amount];
            if (d % 2 == 0) {
                if (cursor == d / 2) {
                    left = amount;
                }
                if (left != -1 && cursor > d / 2) {
                    right = amount;
                    median = (left + right) / 2.0;
                    break;
                }
                if (left == -1 && cursor > d / 2) {
                    median = amount;
                    break;
                }
            } else {
                if (cursor >= d / 2 + 1) {
                    median = amount;
                    break;

                }
            }
        }
        return median;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

    }
}
