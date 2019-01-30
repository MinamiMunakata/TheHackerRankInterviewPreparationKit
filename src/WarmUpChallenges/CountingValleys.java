package WarmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-01-30.
 */
public class CountingValleys {

    private static int getUpOrDown(String s) {
        switch (s) {
            case "U":
                return 1;
            case "D":
                return -1;
            default:
                return 0;
        }
    }

    // Complete the countingValleys function below.
    private static int countingValleys(int n, String s) {
        int current = 0;
        int valleys = 0;
        for (int i = 0; i < n; i++) {
            current += getUpOrDown(s.substring(i, i + 1));

            if (current == 0 && s.substring(i, i + 1).equals("U")) {
                valleys++;
            }
        }
        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

    }
}
