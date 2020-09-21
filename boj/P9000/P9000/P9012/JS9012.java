package boj.P9000.P9000.P9012;

import java.util.Scanner;
import java.util.Stack;

public class JS9012 {
    public static void main(String[] args) {
        new JS9012().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            Stack<Character> s = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                if (s.isEmpty()) {
                    s.add(input.charAt(i));
                } else if (s.peek() == '(' && input.charAt(i) == ')') {
                    s.pop();
                } else {
                    s.add(input.charAt(i));
                }
            }
            System.out.println(s.isEmpty() ? "YES" : "NO");
        }


    }
}
