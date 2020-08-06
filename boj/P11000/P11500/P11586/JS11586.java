package me.kjs.boj.P11000.P11500.P11586;

import java.util.Scanner;

public class JS11586 {

    public static void main(String[] args) {
        new JS11586().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        StringBuffer s[] = new StringBuffer[n];

        for (int i = 0; i < n; i++) {
            s[i]=new StringBuffer();
            String a = sc.nextLine();
            s[i].append(a);
        }

        int r = Integer.valueOf(sc.nextLine());

        if (r == 2) {
            for (int i = 0; i < n; i++) {
                s[i] = s[i].reverse();
            }
        } else if (r == 3) {
            for (int i = 0; i < n/2; i++) {
                StringBuffer temp = s[i];
                s[i] = s[n-i-1];
                s[n-i-1]=temp;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }

    }

}
