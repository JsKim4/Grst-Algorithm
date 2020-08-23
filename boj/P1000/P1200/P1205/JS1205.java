package boj.P1000.P1200.P1205;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JS1205 {


    public static void main(String[] args) {
        new JS1205().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        List<Integer> order = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        list.sort((o1, o2) -> o2 - o1);


        if(order.get(0) == 0) {
            System.out.println(1);
            return;
        }
        int rank = 1;
        if (order.get(1) > list.get(0)) {
            System.out.println(1);
            return;
        }
        int i;
        for (i= 1; i < list.size() && i < order.get(2); i++) {
            if (list.get(i - 1) != list.get(i)) {
                if (order.get(1) == list.get(i - 1)) {
                    System.out.println(rank);
                    return;
                } else if (order.get(1) > list.get(i)) {
                    System.out.println(i + 1);
                    return;
                }
                rank = i + 1;
            }
        }

        if (order.get(2) > list.size()) {
            if (list.get(list.size() - 1) == order.get(1))
                System.out.println(rank);
            else {
                System.out.println(list.size()+1);
            }
        } else {
            System.out.println(-1);
        }
    }
}
