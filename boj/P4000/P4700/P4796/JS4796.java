package boj.P4000.P4700.P4796;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JS4796 {
    public static void main(String[] args) {
        new JS4796().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (++i > 0) {
            List<Integer> inputs = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
            Integer l = inputs.get(0);
            Integer p = inputs.get(1);
            Integer v = inputs.get(2);
            if (l == 0 && p == 0 && v == 0)
                break;
            int result = (v / p * l) + (v % p > l ? l : v % p);
            System.out.println("Case " + i + ": " + result);
        }
    }
}
