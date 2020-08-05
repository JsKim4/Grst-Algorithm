package boj.P11000.P11000.P11080;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JS11080 {

    private void solve() {
        Scanner sc = new Scanner(System.in);
        List<String> strings = Arrays.asList(sc.nextLine().split(" "));
        strings.sort((o1, o2) -> o1.length() > o2.length() ? 1 : o1.length() < o2.length() ? -1 : o1.compareTo(o2));


        int alphaS1[] = new int[26];
        int alphaS2[] = new int[26];

        if (strings.get(0).equals(strings.get(1))) {
            System.out.println(strings.get(0) + " is identical to " + strings.get(1));
        } else {
            for (int i = 0; i < strings.get(0).length(); i++) {
                alphaS1[strings.get(0).charAt(i) - 'a']++;
            }
            for (int i = 0; i < strings.get(1).length(); i++) {
                alphaS2[strings.get(1).charAt(i) - 'a']++;
            }
            int count = 0;
            for (int i = 0; i < 26; i++) {
                count += Math.abs(alphaS1[i] - alphaS2[i]);
            }
            if (count == 0) {
                System.out.println(strings.get(0) + " is an anagram of " + strings.get(1));
            } else if (count == 1) {
                System.out.println(strings.get(0) + " is almost an anagram of " + strings.get(1));
            } else if (count == 2 && strings.get(0).length() == strings.get(1).length()) {
                System.out.println(strings.get(0) + " is almost an anagram of " + strings.get(1));
            } else {
                System.out.println(strings.get(0) + " is nothing like " + strings.get(1));
            }
        }

    }

    public static void main(String[] args) {
        new JS11080().solve();
    }
}
