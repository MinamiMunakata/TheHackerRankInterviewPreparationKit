package Sorting;

import java.io.IOException;
import java.util.Calendar;
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

    static int activityNotifications(int[] expenditure, int d) {
        int notification = 0;
        int[] pastDDays = getPastDDaysHistory(expenditure);
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

    private static int[] getPastDDaysHistory(int[] expenditure) {
        // Create expenditure history for past D days.
        int[] pastDDays = new int[MAX_EXPENDITURE + 1];
        for (int i = 0; i < expenditure.length; i++) {
            pastDDays[expenditure[i]] = pastDDays[expenditure[i]] + 1;
        }
        return pastDDays;
    }


    private static double getMedian(int d, int[] pastDDays) {
        // Find a median
        double median = 0;
        int cursor = 0;
        int left = -1;
        int right = -1;
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
        printArr(pastDDays);
        System.out.println("M: " + median);
        return median;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
//        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};

        int[] testNum = new int[20000];
        int i = 0;
        while (i < testNum.length) {
            for (int j = 0; j < MAX_EXPENDITURE && i < testNum.length; j++) {
                testNum[i] = j;
                i++;
            }
        }
        Calendar start = Calendar.getInstance();
//        int result = activityNotifications(testNum, 1000);
//        int result = activityNotifications(testNum, 1000);
//        int result = activityNotifications(expenditure, 5);
        System.out.println(result);
        Calendar end = Calendar.getInstance();
        System.out.println((end.getTimeInMillis() - start.getTimeInMillis()) / 1000.00);
    }

    static void printArr(int[] arr) {
        for (int n : arr) {
            System.out.print("[" + n + "]");
        }
        System.out.println();
    }

    static void printTrailing(int[] arr, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("****");
        }
        for (int n : arr) {
            System.out.print("[" + n + "]");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
