package me.kjs.boj.P4000.P4300.P4378;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JS4378 {

    public static void main(String[] args) {
        try {
            new JS4378().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final char arr[][] = {{'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='},
            {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'},
            {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\''},
            {'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'}};

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null) {
            String result = "";
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    result += " ";
                    continue;
                }
                result += search(input.charAt(i));
            }
            System.out.println(result);
        }
    }

    private String search(char charAt) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if(charAt == arr[i][j])
                    return String.valueOf(arr[i][j - 1]);
            }
        }
        return null;
    }
}
