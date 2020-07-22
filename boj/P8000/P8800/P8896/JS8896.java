package me.kjs.boj.P8000.P8800.P8896;

import java.util.Scanner;

public class JS8896 {


    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        String[] robot = new String[n];
        boolean[] winner = new boolean[n];
        for (int i = 0; i < n; i++) {
            robot[i] = sc.nextLine();
        }

        for (int j = 0; j < n; j++) {
            boolean rsp[] = new boolean[3];
            for (int i = 0; i < n; i++) {
                if (winner[i]) {
                    continue;
                }
                if (robot[i].charAt(j) == 'P') {
                    rsp[2] = true;
                }
                if (robot[i].charAt(j) == 'S') {
                    rsp[1] = true;
                }
                if (robot[i].charAt(j) == 'R') {
                    rsp[0] = true;
                }
            }

            char winnerChar;
            if (rsp[0] && rsp[1] && rsp[2]) {
                continue;
            }
            if (rsp[0]) {
                if (rsp[1]) {
                    winnerChar = 'R';
                } else if (rsp[2]) {
                    winnerChar = 'P';
                } else {
                    winnerChar = 'S';
                }
            } else {
                if (rsp[1]) {
                    winnerChar = 'S';
                } else {
                    winnerChar = 'P';
                }
            }

            for (int i = 0; i < n; i++) {
                if (winner[i]) {
                    continue;
                }
                if (robot[i].charAt(j) != winnerChar) {
                    winner[i] = true;
                }

            }

        }
        int winnerNum = -1;

        for (int i = 0; i < n; i++) {
            if (winner[i] == false) {
                if (winnerNum == -1) {
                    winnerNum = i+1;
                }else{
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(winnerNum);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        while(T-->0) {
            new JS8896().solve();
        }
    }
}
