package boj.P1000.P1400.P1404;

import java.text.DecimalFormat;
import java.util.Scanner;
public class JS1404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double wc[][] = new double[8][8];
        double wr[][] = new double[3][8];
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                wc[i][j] = sc.nextLong();
                wc[j][i] = 100 - wc[i][j];
            }
        }
        int p = 1;
        for (int r = 0; r < 3; r++) {
            for (int i = 0; i < 4 / p; i++) {
                for (int j = 0; j < p * 2; j++) {
                    int t = i * p * 2 + j;
                    int vt = i * p * 2 + p - j / p * p;
                    for (int v = 0; v < p; v++) {
                        wr[r][t] += wc[t][vt + v] * (r == 0 ? 1 : wr[r - 1][t] * wr[r - 1][vt + v]);
                    }
                }
            }
            p <<= 1;
        }
        for (double l : wr[2]) {
            l /= 100000000000000.0;
            DecimalFormat df = new DecimalFormat("#.##########");
            System.out.print(df.format(l) + " ");
        }
    }
}
