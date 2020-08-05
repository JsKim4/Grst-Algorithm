package boj.P16000.P16900.P16926;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class JS16926 {
    int arr[][];
    int n;
    int m;
    int r;

    public void solve() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < min(n,m) / 2; i++) {
            turn(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int min(int a,int b){
        return a>b?b:a;
    }
    public void turn(int x) {
        Deque<Integer> queue = new LinkedList<>();
        for (int j = x; j < m - x - 1; j++) {
            queue.add(arr[x][j]);
            //System.out.print(arr[x][j]+" ");
        }
        for (int i = x; i < n - x - 1; i++) {
            queue.add(arr[i][m - x - 1]);
            //System.out.print(arr[i][m - x - 1]+" ");
        }
        for (int j = m - x - 1; j > x; j--) {
            queue.add(arr[n - x - 1][j]);
            //System.out.print(arr[n - x - 1][j]+" ");
        }
        for (int i = n - x - 1; i > x; i--) {
            queue.add(arr[i][x]);
            //System.out.print(arr[i][x]+" ");
        }
        int rb = r < queue.size() ? r % queue.size() : r;
        while (rb-- > 0) {
            queue.addLast(queue.pollFirst());
        }
        //System.out.println();
        /*for (Integer integer : queue) {
            System.out.print(integer+" ");
        }*/
        for (int j = x; j < m - x - 1; j++) {
            arr[x][j] = queue.pollFirst();
        }
        for (int i = x; i < n - x - 1; i++) {
            arr[i][m - x - 1] = queue.pollFirst();
        }
        for (int j = m - x - 1; j > x; j--) {
            arr[n - x - 1][j] = queue.pollFirst();
        }
        for (int i = n - x - 1; i > x; i--) {
            arr[i][x] = queue.pollFirst();
        }

    }

    public static void main(String[] args) {
        new JS16926().solve();
    }
}
