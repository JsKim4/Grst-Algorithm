package boj.P1000.P1400.P1470;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JS1470 {

    public void solve() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long l = sc.nextInt();

        List<Country> list = new ArrayList<>();

        long g = sc.nextInt(), s = sc.nextInt(), b = sc.nextInt();
        Country first = new Country(g, s, b);
        first.gold += l;
        for (long i = 0; i < n - 1; i++) {
            g = sc.nextInt();
            s = sc.nextInt();
            b = sc.nextInt();
            list.add(new Country(g, s, b));
        }
        s = l;
        b = l;
        list.sort(null);
        long rank = 1;
        for (Country country : list) {
            Country compare = needWin(first, country);
            if (compare.silver > 0) {
                if (s >= compare.silver) {
                    if (b > compare.bronze) {
                        if (compare.bronze + compare.silver + 1 > l) {
                            if (s > compare.silver) {
                                s -= compare.silver + 1;
                                rank++;
                                continue;
                            } else
                                break;
                        }
                        s -= compare.silver;
                        if (compare.bronze >= 0) {
                            b -= compare.bronze + 1;
                        }
                        rank++;
                    } else {
                        if (s > compare.silver) {
                            s -= compare.silver + 1;
                            rank++;
                        } else
                            break;
                    }
                } else {
                    break;
                }
            } else if (compare.silver == 0) {
                if (b + 1 > compare.bronze) {
                    b -= compare.bronze + 1;
                    if (compare.bronze > l) {
                        break;
                    }
                    rank++;
                } else if (s > 0) {
                    s -= 1;
                    rank++;
                } else {
                    break;
                }
            } else {
                rank++;
            }
        }
        System.out.println(rank);
    }

    public static void main(String[] args) {
        new JS1470().solve();
    }

    public Country needWin(Country o1, Country o2) {
        if (o1.compareTo(o2) == 1) {
            return new Country(0L, -1L, -1L);
        }
        return new Country(0L, o1.silver - o2.silver, o1.bronze - o2.bronze);
    }

    private class Country implements Comparable<Country> {
        public Long gold = 0L;
        public Long silver = 0L;
        public Long bronze = 0L;

        public Country() {
        }


        @Override
        public int compareTo(Country o) {
            int g = o.gold.compareTo(this.gold);
            if (g != 0)
                return g;

            int s = o.silver.compareTo(this.silver);
            if (s != 0)
                return s;

            int b = o.bronze.compareTo(this.bronze);
            return b;
        }

        public Country(Long gold, Long silver, Long bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "gold=" + gold +
                    ", silver=" + silver +
                    ", bronze=" + bronze +
                    '}';
        }
    }
}
