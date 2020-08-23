package boj.P1000.P1100.P1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JS1181 {

    public static void main(String[] args) {
        try {
            new JS1181().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void solve() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());

        ArrayList<String> pro = new ArrayList<>();

        while (n-- > 0) {
            String s = bf.readLine();
            pro.add(s);
        }
        pro.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < pro.size(); i++) {
            if (i == 0)
                System.out.println(pro.get(i));
            else if (pro.get(i).equals(pro.get(i - 1)) == false) {
                System.out.println(pro.get(i));
            }
        }
    }
}
