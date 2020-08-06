package boj.P1000.P1700.P1783;

import java.util.Scanner;


public class JS1783 {


    public static void main(String[] args) {
        new JS1783().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        int answer = 0;
        if (height == 1) {
            answer = 1;
        } else if (height == 2) {
            answer = (width + 1) / 2;
            answer = answer > 4 ? 4 : answer;
        }else{
            if(width < 5){
                answer = width;
            }
            else if(width == 5){
                answer = 4;
            }else{
                answer = width-2;
            }
        }
        System.out.println(answer);

    }
}
