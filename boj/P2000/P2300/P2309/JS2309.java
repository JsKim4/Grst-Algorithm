package boj.P2000.P2300.P2309;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JS2309 {

    public void solve() {
        Scanner sc = new Scanner(System.in);
        List<Integer> n = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int num = sc.nextInt();
            n.add(num);
        }
        n.sort(null);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j)
                    continue;
                int sum = calcu(i, j, n);
                if (sum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        System.out.println(n.get(k));
                    }
                    return;
                }
            }
        }
    }

    private int calcu(int i, int j, List<Integer> n) {
        int sum = 0;
        for (int k = 0; k < 9; k++) {
            if (k == i || k == j)
                continue;
            sum += n.get(k);
        }
        return sum;
    }


    public static void main(String[] args) {
        new JS2309().solve();
    }
}
