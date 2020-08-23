package boj.P1000.P1400.P1475;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JS1475 {

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[11];
        Arrays.asList(sc.nextLine().split(""))
                .stream()
                .map(Integer::parseInt)
                .map(l -> num[l]++)
                .collect(Collectors.toList());
        num[10] = num[6];
        num[6] = (num[6] + num[9]) / 2;
        num[9] = (num[10] + num[9]) / 2 + (num[10] + num[9]) % 2;
        num[10]=0;
        int max = 0;
        for (int i : num) {
            if(max<i)
                max = i;
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        new JS1475().solve();
    }
}
