package Arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-09-29.
 */
public class TwoDArrayDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = -63;
        for (int row = 0; row <= 3; row++) {
            for (int col = 0; col <= 3; col++) {
                int hourglass = arr[row][col] + arr[row][col + 1] + arr[row][col + 2] +
                                arr[row + 1][col + 1] +
                                arr[row + 2][col] + arr[row + 2][col + 1] + arr[row + 2][col + 2];
                if (max < hourglass) {
                    max = hourglass;
                }
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
        System.out.println(result);
    }
}
