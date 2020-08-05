package boj.P1000.P1000.P1051;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JS1051 {

    private void solve() {
        Scanner sc = new Scanner(System.in);
        List<Integer> nm = Arrays.asList(sc.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int n = nm.get(0);
        int m = nm.get(1);
        int map[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            List<Integer> temp = Arrays.asList(sc.nextLine().split("")).stream().map(Integer::parseInt).collect(Collectors.toList());
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.get(j);
            }
        }
        int maxLength = n > m ? m : n;
        while (maxLength > 0) {
            for (int i = 0; i + maxLength < n; i++) {
                for (int j = 0; j + maxLength < m; j++) {

                }
            }
            maxLength--;
        }

    }

    public static void main(String[] args) {
        new JS1051().solve();
    }

}
