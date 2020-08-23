package boj.P2000.P2800.P2840;

import java.util.Scanner;

public class JS2840 {


    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int arr[] = new int[n];
        int now = 0;
        boolean isYes[] = new boolean[26];
        boolean isFalse = false;
        while (k-- > 0) {
            int rolling = sc.nextInt();
            char character = sc.nextLine().charAt(1);
            now += (n - (rolling%n));
            now %= n;
            if (arr[now] == 0) {
                if (isYes[(int) character - (int) 'A'] == false) {
                    arr[now] = (int) character;
                    isYes[(int) character - (int) 'A'] = true;
                }
                else
                    isFalse = true;
            } else if (arr[now] != (int) character) {
                isFalse = true;
            }
        }
        if (isFalse) {
            System.out.println("!");
            return;
        }


        for (int i = now; i < n; i++) {
            if (arr[i] == 0) {
                System.out.print("?");
            } else {
                System.out.print((char) arr[i]);
            }
        }
        for (int i = 0; i < now; i++) {
            if (arr[i] == 0) {
                System.out.print("?");
            } else {
                System.out.print((char) arr[i]);
            }
        }


    }

    public static void main(String[] args) {
        new JS2840().solve();
    }
}
