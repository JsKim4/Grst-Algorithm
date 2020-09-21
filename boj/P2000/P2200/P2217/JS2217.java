package boj.P2000.P2200.P2217;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JS2217 {
    public static void main(String[] args) {
        new JS2217().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while (t-- > 0) {
            int num = sc.nextInt();
            list.add(num);
        }
        list.sort((o1, o2) -> o2 - o1);
        int answer = 0;
        int count = 0;
        for (Integer integer : list) {
            count++;
            if (answer < count * integer) {
                answer = count * integer;
            }
        }
        System.out.println(answer);
    }
}
