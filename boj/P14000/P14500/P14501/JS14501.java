package boj.P14000.P14500.P14501;

import java.util.Scanner;

public class JS14501 {
    public static void main(String[] args) {
        new JS14501().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int days[] = new int[n + 1];

        int max = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int p = sc.nextInt();

            if (max < days[i]) {
                max = days[i];
            }
            if (i + t > n) {
                continue;
            }
            if (max + p > days[i + t]) {
                days[i + t] = max + p;
            }
        }

        for (int day : days) {
            if (max < day)
                max = day;
        }
        System.out.println(max);
    }
}
