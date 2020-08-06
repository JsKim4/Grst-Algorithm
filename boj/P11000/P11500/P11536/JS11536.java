package boj.P11000.P11500.P11536;

import java.util.Scanner;

public class JS11536 {


    public static void main(String[] args) {
        new JS11536().solve();
    }

    private int compare(String a, String b) {
        int i = a.compareTo(b);
        if (i < 0) {
            return -1;
        } else if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());

        String s[] = new String[n];
        s[0] = sc.nextLine();
        s[1] = sc.nextLine();
        int cre = compare(s[0],s[1]);

        for (int i = 2; i < n; i++) {
            s[i] = sc.nextLine();
            if ( compare(s[i-1],s[i]) != cre) {
                cre = 0;
                break;
            }
        }

        if (cre == -1) {
            System.out.println("INCREASING");
        } else if (cre == 1) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }

    }
}
