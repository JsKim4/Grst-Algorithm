package me.kjs.boj.P17000.P17100.P17176;

import java.util.Scanner;

public class JS17176 {

    public static void main(String[] args) {
        new JS17176().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        Integer length = Integer.valueOf(sc.nextLine());
        int arr[] = new int[53];
        String[] s = sc.nextLine().split(" ");
        for (String s1 : s) {
            arr[Integer.valueOf(s1)]++;
        }

        String enc = sc.nextLine();

        char[] chars = enc.toCharArray();

        for (char aChar : chars) {
            if (aChar == ' ') {
                arr[0]--;
            }
            else if (aChar >= 'a' && aChar <= 'z') {
                arr[27 + aChar - 'a']--;
            } else {
                arr[1 + aChar - 'A']--;
            }
        }
        for (int i : arr) {
            if(i<0){
                System.out.println("n");
                return;
            }
        }
        System.out.println("y");

    }
}
