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
            for (int i = 0; i + maxLength <= n; i++) {
                for (int j = 0; j + maxLength <= m; j++) {
                    boolean isSame = isSameWidth(i, j, i + maxLength, j + maxLength, map);
                    if(isSame){
                        System.out.println(maxLength*maxLength);
                        return;
                    }
                }
            }
            maxLength--;
        }

    }

    private boolean isSameWidth(int i, int j, int maxI, int maxJ, int[][] map) {
        if(map[i][j]==map[i][maxJ-1]&&map[maxI-1][j]==map[maxI-1][maxJ-1]&&map[i][j]==map[maxI-1][maxJ-1])
            return true;
        return false;
    }

    public static void main(String[] args) {
        new JS1051().solve();
    }

}
