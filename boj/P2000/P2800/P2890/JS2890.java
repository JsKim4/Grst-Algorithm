package boj.P2000.P2800.P2890;

import java.util.Scanner;

public class JS2890 {
    public static void main(String[] args) {
        new JS2890().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        int ranks[] = new int[9];
        int rank = 1;
        String[] leaver = new String[r];
        for (int i = 0; i < r; i++) {
            leaver[i] = sc.nextLine();
        }

        for (int i = c - 2; i > 0; i--) {
            boolean rankUp = false;
            for (int j = 0; j < r; j++) {
                if (leaver[j].charAt(i) != 'F' && leaver[j].charAt(i) != 'S' && leaver[j].charAt(i) != '.') {
                    if(ranks[(leaver[j].charAt(i))-'0'-1] != 0)
                        continue;
                    rankUp = true;
                    ranks[(leaver[j].charAt(i))-'0'-1] = rank;
                }
            }
            if(rankUp)
                rank++;
        }
        for(int i:ranks){
            System.out.println(i);
        }

    }
}
