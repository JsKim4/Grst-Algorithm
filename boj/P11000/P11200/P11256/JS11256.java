package boj.P11000.P11200.P11256;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JS11256 {
    public static void main(String[] args) {
        new JS11256().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int j = sc.nextInt();
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                int width = sc.nextInt();
                int height = sc.nextInt();
                list.add(width * height);
            }
            list.sort((o1, o2) -> o2 - o1);
            int count = 0;
            for (Integer integer : list) {
                j -= integer;
                count++;
                if (j <= 0) {
                    System.out.println(count);
                    break;
                }
            }
        }
    }
}
