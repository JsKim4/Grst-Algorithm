package boj.P16000.P16200.P16238;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class JS16238 {
    public static void main(String[] args) {
        new JS16238().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine());
        List<Long> inputs = Arrays.asList(sc.nextLine().split(" ")).stream().map(Long::parseLong).collect(Collectors.toList());

        inputs.sort(null);

        long max = inputs.stream().flatMapToLong(num -> LongStream.of(num)).sum();

        long result = 0;
        for (Long input : inputs) {
            max -= input;
            result += input * max;
        }
        System.out.println(result);
    }
}
