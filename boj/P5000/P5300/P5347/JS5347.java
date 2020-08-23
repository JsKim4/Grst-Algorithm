package boj.P5000.P5300.P5347;

import java.util.Scanner;

public class JS5347 {


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            new JS5347().solve();
        }
    }

    private void solve() {
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if (num1 < num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }

        int tNum1 = num1;
        int tNum2 = num2;
        int remainder = tNum1 % tNum2;
        while (remainder != 0) {
            tNum1 = tNum2;
            tNum2 = remainder;
            remainder = tNum1 % tNum2;
        }

        System.out.println(num1 * (num2 / tNum2));
    }
}
