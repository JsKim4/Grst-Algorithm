package boj.P1000.P1200.P1244;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JS1244 {
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int switchCount = Integer.parseInt(sc.nextLine());
        List<Boolean> list = Arrays.asList(sc.nextLine().split(" ")).stream()
                .map(Integer::parseInt)
                .map(i -> i == 1)
                .collect(Collectors.toList());

        int orderCount = Integer.parseInt(sc.nextLine());
        while (orderCount-- > 0) {
            List<Integer> order = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt)
                    .collect(Collectors.toList());
            // 1 = 배수 변경 ,2 = 대칭 변경
            if (order.get(0) == 1) {
                for (int i = order.get(1); i <= switchCount; i += order.get(1)) {
                    list.set(i - 1, !list.get(i - 1));
                }
            } else {
                int i = order.get(1);
                int j = order.get(1);
                while ((i > 0 && j <= switchCount) && list.get(i - 1) == list.get(j - 1)) {
                    boolean isOn = !list.get(i - 1);
                    list.set(i - 1, isOn);
                    list.set(j - 1, isOn);
                    i--;
                    j++;
                }
            }
        }
        for (int i = 0; i <= switchCount / 20; i++) {
            for (int j = 0; j < 20; j++) {
                if ((i * 20 + j ) == switchCount) {
                    return;
                }
                System.out.print((list.get(i * 20 + j)?1:0)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new JS1244().solve();
    }
}
