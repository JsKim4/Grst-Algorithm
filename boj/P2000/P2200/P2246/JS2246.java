package boj.P2000.P2200.P2246;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JS2246 {
    public static void main(String[] args) throws IOException {
        new JS2246().solve();
    }

    private void solve() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bufferedReader.readLine());
        List<Pair> num = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            Pair pair = new Pair();
            pair.length = Integer.parseInt(s[0]);
            pair.price = Integer.parseInt(s[1]);
            num.add(pair);
        }

        int count = 0;
        for (Pair pair : num) {
            boolean b = num.stream()
                    .anyMatch(p -> pair.isAvail(p) == false);
            if(!b)
                count++;
        }
        System.out.println(count);

    }

    private class Pair {
        public int length;
        public int price;

        public boolean isAvail(Pair o) {
            if (length > o.length) {
                return price < o.price;
            }
            if (price > o.price) {
                return length < o.length;
            }
            return true;
        }
    }
}
