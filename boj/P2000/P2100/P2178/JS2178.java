package boj.P2000.P2100.P2178;

import java.util.*;

public class JS2178 {
    public static void main(String[] args) {
        new JS2178().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int[][] way = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int arr[][] = new int[n][m];
        List<Pair> road[][] = new ArrayList[n][m];
        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(strings[j]) - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                road[i][j] = new ArrayList<>();
                for (int w = 0; w < 4; w++) {
                    int wy = i + way[w][0];
                    int wx = j + way[w][1];
                    if (isAvail(wy, wx, n, m) && arr[wy][wx] == 0) {
                        road[i][j].add(new Pair(wy, wx));
                    }
                }
            }
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));
        arr[0][0] = 1;
        int count = 1;
        while (q.isEmpty() == false) {
            int len = q.size();
            count++;
            while (len-- > 0) {
                Pair p = q.poll();
                int y = p.first;
                int x = p.second;
                for (Pair pair : road[y][x]) {
                    if (arr[pair.first][pair.second] == 0) {
                        arr[pair.first][pair.second] = count;
                        q.add(pair);
                    }
                }
            }
        }

        System.out.println(arr[n - 1][m - 1]);
    }

    private boolean isAvail(int wy, int wx, int n, int m) {
        if (wy >= 0 && wy < n && wx >= 0 && wx < m)
            return true;
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
