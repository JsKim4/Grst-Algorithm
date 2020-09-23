package boj.P1000.P1700.P1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class JS1764 {
    public static void main(String[] args) throws IOException {
        new JS1764().solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> dbjCount = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int d = dbjCount.get(0);
        int b = dbjCount.get(1);
        List<String> dList = new ArrayList<>();
        List<String> bList = new ArrayList<>();
        while (d-- > 0) {
            dList.add(br.readLine());
        }
        while (b-- > 0) {
            bList.add(br.readLine());
        }
        dList.sort(null);
        bList.sort(null);


        Stack<String> ds = new Stack<>();
        Stack<String> bs = new Stack<>();
        ds.addAll(dList);
        bs.addAll(bList);

        Stack<String> result = new Stack<>();
        while (ds.isEmpty() == false && bs.isEmpty() == false) {
            int i = ds.peek().compareTo(bs.peek());
            if (i == 0) {
                result.add(ds.pop());
                bs.pop();
            } else if (i < 0) {
                bs.pop();
            } else {
                ds.pop();
            }
        }
        System.out.println(result.size());
        while(result.isEmpty() == false){
            System.out.println(result.pop());
        }
    }
}
