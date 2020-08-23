package boj.P1000.P1200.P1251;


import java.util.Scanner;

public class JS1251 {

    public void solve() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        String first = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        for (int i = 1; i < inputString.length() - 1; i++) {
            for (int j = i + 1; j < inputString.length() ; j++) {
                String makes = makeString(inputString, i, j);
                if(first.compareTo(makes) >0){
                    first = makes;
                }
            }
        }
        System.out.println(first);
    }

    private String makeString(String inputString, int i, int j) {
        StringBuffer s1 = new StringBuffer(inputString.substring(0, i));
        StringBuffer s2 = new StringBuffer(inputString.substring(i, j));
        StringBuffer s3 = new StringBuffer(inputString.substring(j));

        return s1.reverse().toString() + s2.reverse().toString() + s3.reverse().toString();
    }


    public static void main(String[] args) {
        new JS1251().solve();
    }
}
