package testM3;

import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-10-01.
 */
public class RemoveOdd {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();

        String[] values = inputLine.split(",");
        boolean comma = false;
        for (int i = 0; i < values.length; i++) {
            int n = Integer.parseInt(values[i]);
            if ((i + 1) % 2 == 0 || (i > 0 && Integer.parseInt(values[i - 1]) == n)) {
                if (comma) {
                    System.out.print(",");
                }
                System.out.print(n);
                comma = true;
            }

        }
    }
}
