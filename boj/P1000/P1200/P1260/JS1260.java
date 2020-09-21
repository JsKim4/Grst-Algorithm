package boj.P1000.P1200.P1260;

import java.util.*;

public class JS1260 {


    public static void main(String[] args) {
        new JS1260().solve();
    }


    boolean checkPoint[];
    List<Integer> load[];

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        checkPoint = new boolean[n + 1];
        load = new ArrayList[n + 1];
        for (int i = 0; i < load.length; i++) {
            load[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            load[s].add(e);
            load[e].add(s);
        }
        for (int i = 0; i < load.length; i++) {
            load[i].sort(null);
        }
        checkPoint[v] = true;
        dfs(v);
        System.out.println();

        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        checkPoint = new boolean[n + 1];
        checkPoint[v] = true;
        while (q.isEmpty() == false) {
            int len = q.size();
            while (len-- > 0) {
                int num = q.poll();
                System.out.print(num+" ");
                for (int i = 0; i < load[num].size(); i++) {
                    Integer next = load[num].get(i);
                    if (checkPoint[next] == false) {
                        checkPoint[next] = true;
                        q.add(next);
                    }
                }
            }
        }

    }

    private void dfs(int v) {
        System.out.print(v + " ");
        for (int i = 0; i < load[v].size(); i++) {
            Integer next = load[v].get(i);
            if (checkPoint[next] == false) {
                checkPoint[next] = true;
                dfs(next);
            }
        }
    }


}
