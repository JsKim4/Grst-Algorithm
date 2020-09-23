package boj.P7000.P7500.P7576;

import java.util.*;

public class JS7576 {
    public static void main(String[] args) {
        new JS7576().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[n][m];
        List<Pair>[][] street = new ArrayList[n][m];
        int way[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Pair> tomato = new ArrayDeque<>();
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    tomato.add(new Pair(i, j));
                }else if(arr[i][j]==0){
                    zeroCount++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                street[i][j] = new ArrayList<>();
                for (int w = 0; w < 4; w++) {
                    int wy = i + way[w][0];
                    int wx = j + way[w][1];
                    if (isAvail(wy, wx, n, m) && arr[wy][wx] == 0) {
                        street[i][j].add(new Pair(wy,wx));
                    }
                }
            }
        }

        if(zeroCount == 0){
            System.out.println(0);
            return;
        }

        int time = 1;
        while (tomato.isEmpty() == false) {
            int len = tomato.size();
            while (len-- > 0) {
                Pair p = tomato.poll();
                for (Pair pair : street[p.first][p.second]) {
                    int wy = pair.first;
                    int wx = pair.second;
                    if (arr[wy][wx] == 0) {
                        arr[wy][wx] = time;
                        tomato.add(new Pair(wy, wx));
                    }
                }
            }
            time++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < arr[i][j])
                    max = arr[i][j];
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);
    }

    public boolean isAvail(int i, int j, int n, int m) {
        if (i >= 0 && i < n && j >= 0 && j < m) {
            return true;
        }
        return false;
    }

    private class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
