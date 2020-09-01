package boj.P2000.P2800.P2891;

import java.util.Scanner;

public class JS2891 {


    public static void main(String[] args) {
        new JS2891().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[11];
        int n = sc.nextInt();
        int s = sc.nextInt();
        int r = sc.nextInt();
        for (int i = 0; i < s; i++) {
            arr[sc.nextInt() - 1]--;
        }
        for (int i = 0; i < r; i++) {
            arr[sc.nextInt() - 1]++;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                if (i != 0) {
                    if (arr[i - 1] == 1) {
                        continue;
                    }
                }
                if (arr[i + 1] == 1) {
                    arr[i + 1] = 0;
                    continue;
                }
                answer++;
            }
        }
        System.out.println(answer);


    }
}
