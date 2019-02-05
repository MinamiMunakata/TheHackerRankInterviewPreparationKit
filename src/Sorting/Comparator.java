package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by minami_munakata on 2019-02-04.
 */

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements java.util.Comparator<Player> {
    // complete this method
    @Override
    public int compare(Player a, Player b) {
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        } else {
            return b.score - a.score;
        }
    }


}

public class Comparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

//        Player[] player = new Player[] {
//                new Player("amy", 100),
//                new Player("david", 100),
//                new Player("heraldo", 50),
//                new Player("aakansha", 75),
//                new Player("aleksa", 150)};
//        Checker checker = new Checker();

        Arrays.sort(player, checker);
        for (Player aPlayer : player) {
            System.out.printf("%s %s\n", aPlayer.name, aPlayer.score);
        }
    }
}
