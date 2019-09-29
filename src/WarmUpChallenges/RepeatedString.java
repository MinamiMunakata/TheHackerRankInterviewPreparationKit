package WarmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-09-29.
 */
public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        char a = 'a';
        long count = 0;
        long length = s.length();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) {
                count++;
            }
        }
        count = count * ( n / length);
        if (n % s.length() != 0) {
            for(int i = 0; i < n % s.length(); i++) {
                if (s.charAt(i) == a) {
                    count++;
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
        System.out.printf("Result: %d%n", result);
    }
}
