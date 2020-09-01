package boj.P2000.P2700.P2777;

import java.util.Scanner;

public class JS2777 {
    public static void main(String[] args) {
        new JS2777().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            if(n==1){
                System.out.println(1);
                continue;
            }


            int result = 0;
            for (int i = 9; i > 1; i--) {
                if (n % i == 0) {
                    result++;
                    n /= i;
                    i++;
                }
            }

            if (n == 1)
                System.out.println(result);
            else
                System.out.println(-1);
        }
    }
}
