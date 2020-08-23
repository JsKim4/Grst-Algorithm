package boj.P13000.P13300.P13305;

import java.util.Scanner;

public class JS13305 {

    public static void main(String[] args) {
        new JS13305().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine());
        long min = Integer.MAX_VALUE;
        long length = 0;
        long result = 0;
        String[] cityLen = sc.nextLine().split(" ");
        String[] cityOil = sc.nextLine().split(" ");

        min = Long.parseLong(cityOil[0]);
        for (int i = 1; i < cityOil.length; i++) {
            length += Long.valueOf(cityLen[i - 1]);
            long nowOil = Long.parseLong(cityOil[i]);

            if (nowOil < min) {
                result += min * length;
                length = 0;
                min = nowOil;
            }
        }
        result += min * length;

        System.out.println(result);
    }
}
