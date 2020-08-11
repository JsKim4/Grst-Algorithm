package me.kjs.boj.P1000.P1900.P1914;

import java.util.Scanner;

public class JS1944 {
    public static void main(String[] args) {
        while (true) new JS1944().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long resultA = 1;
        long resultB = 0;
        for (int i = 0; i < n; i++) {
            resultA *= 2;
            resultB *= 2;
            resultB += resultA/1000000000000L;
            resultA %= 1000000000000L;
        }
        System.out.println((resultB!=0?resultB+"":"")+(resultA-1));

        if (n > 20)
            return;
        move(n, 1, 3, 2);
    }

    private void move(int n, int from, int to, int by) {
        if (n == 1) {
            System.out.println(from + " " + to);
            return;
        }
        move(n - 1, from, by, to);
        System.out.println(from + " " + to);
        move(n - 1, by, to, from);
    }
}
