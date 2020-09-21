package boj.P1000.P1300.P1316;

import java.util.Scanner;

public class JS1316 {
    public static void main(String[] args) {
        new JS1316().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int result = t;
        while (t-- > 0) {
            boolean alpha[] = new boolean[26];
            String s = sc.nextLine();
            alpha[s.charAt(0) - 'a'] = true;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    int index = s.charAt(i) - 'a';
                    if (alpha[index] == true) {
                        result--;
                        break;
                    }
                    alpha[index] = true;
                }
            }
        }
        System.out.println(result);
    }
}
