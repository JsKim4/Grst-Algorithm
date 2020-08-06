package me.kjs.boj.P14000.P14500.P14582;

import java.util.Scanner;

public class JS14582 {


    public void solve() {
        Scanner sc = new Scanner(System.in);

        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");

        int a = 0;
        int b = 0;
        boolean isWin = false;

        int scoreList[][] = new int[2][9];
        for (int i = 0;i<9;i++) {
            a += Integer.parseInt(s1[i]);
            if(a>b){
                isWin = true;
            }
            b += Integer.parseInt(s2[i]);
        }
        System.out.println(isWin ? "Yes" : "No");
    }

    public static void main(String[] args) {
        new JS14582().solve();
    }

}
