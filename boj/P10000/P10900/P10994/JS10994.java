package boj.P10000.P10900.P10994;

import java.util.Scanner;

public class JS10994 {

    public static void main(String[] args) {
        new JS10994().solve();
    }

    boolean arr[][];

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        arr = new boolean[4 * x - 3][4 * x - 3];
        for (int j = 0; j < x; j++) {
            tintStar(j * 2, j * 2, (j * 2) + (x - j - 1) * 4 + 1, j * 2, 0);
        }
        for (int i = 0; i < x * 4 - 3; i++) {
            for (int j = 0; j < x * 4 - 3; j++) {
                if (arr[i][j]) {
                    System.out.print("*");
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


    private final int way[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void tintStar(int nowY, int nowX, int max, int min, int w) {
        if (w == 4) {
            return;
        }
        arr[nowY][nowX] = true;
        if (availCheck(nowY + way[w][0], nowX + way[w][1], max, min)) {
            tintStar(nowY + way[w][0], nowX + way[w][1], max, min, w);
        } else {
            tintStar(nowY, nowX, max, min, w + 1);
        }
    }

    private boolean availCheck(int y, int x, int max, int min) {
        if (y >= min && y < max && x >= min && x < max)
            return true;
        return false;
    }
}
