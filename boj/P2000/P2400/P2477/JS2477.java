package boj.P2000.P2400.P2477;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JS2477 {
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a[] = new int[6];
        List<Integer> aa = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            a[i] = sc.nextInt();
            a[i] = sc.nextInt();
            aa.add(a[i]);
        }
        int max = 0;
        int max_i = 0;
        for (int i = 0; i < 6; i++) {
            if (max < aa.get(i)) {
                max_i = i;
                max = aa.get(i);
            }
        }
        int max_j = 0;
        int min_j = 0;
        int sm_i = 0;
        int sm_j = 0;
        if (max_i == 5) {
            if (aa.get(0) > aa.get(4)) {
                max_j = 0;
                sm_i = 3;
                sm_j = 2;
            } else {
                max_j = 4;
                sm_i = 1;
                sm_j = 2;
            }
        } else if (max_i == 0) {
            if (aa.get(5) > aa.get(1)) {
                max_j = 5;
                sm_i = 2;
                sm_j = 3;
            } else {
                max_j = 1;
                sm_j = 4;
                sm_i = 3;
            }
        } else {
            if (aa.get(max_i - 1) > aa.get(max_i + 1)) {
                max_j = max_i - 1;
                sm_i = (max_i + 2) % 6;
                sm_j = (max_i + 3) % 6;
            } else {
                max_j = max_i + 1;
                sm_i = (max_i - 2 + 6) % 6;
                sm_j = (max_i - 3 + 6) % 6;
            }
        }
        int maxSize = aa.get(max_i) * aa.get(max_j);
        int minSize = aa.get(sm_i) * aa.get(sm_j);
        System.out.println((maxSize - minSize) * k);
    }

    public static void main(String[] args) {
        new JS2477().solve();
    }
}
