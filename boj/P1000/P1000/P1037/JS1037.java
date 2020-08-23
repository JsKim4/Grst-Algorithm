package boj.P1000.P1000.P1037;

import java.util.Scanner;

public class JS1037 {

    public static void main(String[] args) {
        new JS1037().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int min = 1000000;

        while (n-- > 0) {
            int num = sc.nextInt();
            if (num > max) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        System.out.println(max*min);
    }
}
