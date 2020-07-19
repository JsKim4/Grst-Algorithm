package me.kjs.boj.P11000.P11600.P11637;

import java.util.Scanner;

public class JS11637 {
    Scanner sc = new Scanner(System.in);


    public void solve() {
        int T = sc.nextInt();
        while (T-- > 0) {
            subSolve();
        }

    }

    public void subSolve() {
        int length = sc.nextInt();

        int max = 0;
        int max_i = 0;
        int sum = 0;
        int i = 0;
        int now = 0;
        boolean overlap = false;

        while (++i <= length) {
            now = sc.nextInt();
            sum += now;
            if (max < now) {
                max = now;
                overlap = false;
                max_i = i;
            }else if(max == now){
                overlap = true;
            }
        }

        if (overlap) {
            System.out.println("no winner");
            return;
        }
        if (max * 2 > sum) {
            System.out.println("majority winner "+max_i);
            return;
        } else {
            System.out.println("minority winner "+max_i);
            return;
        }

    }

    public static void main(String[] args) {
        new JS11637().solve();

    }
}
