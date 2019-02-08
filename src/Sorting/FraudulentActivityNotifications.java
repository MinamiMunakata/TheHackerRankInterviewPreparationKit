package Sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-02-06.
 */
public class FraudulentActivityNotifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        int i = 0;
        while (i < expenditure.length - d) {
            int[] trailing = new int[d];
            int j = 0;
            while (j < d) {
                trailing[j] = expenditure[i + j];
                j++;
            }
            Arrays.sort(trailing);

            int median = trailing[d / 2];
            if (expenditure[i + d] >= median * 2) {
                count++;
            }
            i++;
        }
        return count;
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
//        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int[] expenditure = {30, 90, 20, 30, 40};
        printArr(expenditure);


//        System.out.println(activityNotifications(expenditure, 5));
    }

    static void printArr(int[] arr) {
        for (int n: arr) {
            System.out.print("[" + n + "]");
        }
        System.out.println();
    }

//    static void mSort(int[] arr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int index = p(arr, left, right);
//        mSort(arr, left, index - 1);
//        mSort(arr, index, right);
//
//    }
//
//    private static int p(int[] arr, int left, int right) {
//        printArr(arr);
//        System.out.println(String.format("L: %d [%d], R: %d [%d]", left, arr[left], right, arr[right]));
//        int pivot = arr[right];
//        while (left < right) {
//            while (arr[left] < pivot) {
//                left++;
//            }
//            while (arr[right] > pivot) {
//                right--;
//            }
//            if (left < right) {
//                swap(arr, left, right);
//                left++;
//                right--;
//            }
//        }
//        return left;
//    }
//
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
