package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputs = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<List<Integer>> arrays = new ArrayList<>();

        for (Integer h = 0; h < inputs.get(0); h++) {
            List<Integer> numbers = new ArrayList<>();
            for (String s : scanner.nextLine().split("")) {
                numbers.add(Integer.parseInt(s));
            }
            arrays.add(numbers);
        }

        Integer kernel = inputs.get(0) > inputs.get(1) ? inputs.get(1) : inputs.get(1);
        for ( Integer k = kernel; k >= 0; k-- ) {
            for (Integer h = 0; h + k < inputs.get(0); h++) {
                for (Integer w = 0; w + k < inputs.get(1); w++) {
                    if ( arrays.get(h).get(w) == arrays.get(h).get(w + k) &&
                        arrays.get(h).get(w) == arrays.get(h + k).get(w) &&
                        arrays.get(h).get(w) == arrays.get(h + k).get(w + k) ) {
                        System.out.println((k + 1) * (k + 1));
                        return;
                    }
                }
            }
        }
    }
}
