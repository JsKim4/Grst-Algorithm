package boj.P2000.P2800.P2847;

import java.util.*;

public class JS2847 {

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int min = num;
            for (int j = list.size() - 1; j >= 0; j--) {
                Integer now = list.get(j);
                if (now >= min){
                    int dif = now - min + 1;
                    now-=dif;
                    result += dif;
                    list.set(j,now);
                    min = now;
                }else
                    break;
            }
            list.add(num);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        new JS2847().solve();
    }
}
