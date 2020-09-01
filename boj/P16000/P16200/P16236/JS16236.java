package boj.P16000.P16200.P16236;

import java.security.KeyPair;
import java.util.*;
import java.util.stream.Collectors;

public class JS16236 {

    public static void main(String[] args) {
        new JS16236().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair.n = n;
        int sea[][] = new int[n][n];

        int way[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        Shark shark = new Shark();

        int sharks[] = {0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sea[i][j] = sc.nextInt();
                if (sea[i][j] == 9) {
                    shark.y = i;
                    shark.x = j;
                } else
                    sharks[sea[i][j]]++;
            }
        }

        while (true) {

            boolean isNotAvailEat = true;
            for (int i = 1; i < shark.nowSize; i++) {
                if (sharks[i] != 0)
                    isNotAvailEat = false;
            }

            if (isNotAvailEat)
                break;

            int tempSea[][] = sea;

            int count = 0;

            Queue<Pair> q = new ArrayDeque<>();

            q.add(new Pair(shark.y, shark.x));

            while (q.isEmpty() == false) {
                int len = q.size();
                for (int i = 0; i < len; i++) {
                    Pair front = q.poll();
                }
            }

        }
    }

    private class Shark {
        int nowSize = 2;
        int y = 0;
        int x = 0;
        int eat = 0;
        int count = 0;

        private void levelUp() {
            if (eat == nowSize) {
                nowSize++;
                eat = 0;
            }
        }

        public void eat(int y, int x, int count) {
            count += this.count;
            this.y = y;
            this.x = x;
            eat++;
            levelUp();
        }


        public boolean eatAvail(int size) {
            if (size > 0 && size < nowSize) {
                return true;
            }
            return false;
        }
    }

    private static class Pair {
        int y;
        int x;
        public static int n;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public boolean isAvail(int yAdd, int xAdd) {
            int wy = y + yAdd;
            int wx = x + xAdd;

            if (wy >= 0 && wy < n && wx >= 0 && wx < n)
                return true;
            return false;
        }
    }
}
