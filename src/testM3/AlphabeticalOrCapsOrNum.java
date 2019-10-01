package testM3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-10-01.
 */
public class AlphabeticalOrCapsOrNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.next().replaceAll("[,.\\s]", ""));
        }
        for (int i = 0; i < input.size(); i++) {
            if (Character.isUpperCase(input.get(i).charAt(0))) {
                // Check if the first letter is uppercase or number, and count it.

            }
        }
        System.out.println(input.toString());
    }


}
