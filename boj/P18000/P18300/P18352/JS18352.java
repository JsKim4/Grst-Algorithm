package boj.P18000.P18300.P18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class JS18352 {
    public static void main(String[] args) throws IOException {
        new JS18352().solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> orders = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());

        int cityCount = orders.get(0);
        int roadCount = orders.get(1);
        int searchLength = orders.get(2);
        int startCity = orders.get(3);

        Edge edges[] = new Edge[cityCount + 1];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Edge(i);
        }

        for (int i = 0; i < roadCount; i++) {
            List<Integer> inputs = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
            int start = inputs.get(0);
            int goal = inputs.get(1);
            edges[start].addRoad(goal, 1);
        }

        List<Edge> result = new ArrayList<>();
        PriorityQueue<Edge> q = new PriorityQueue();
        edges[startCity].len = 0;
        for (Edge edge : edges) {
            q.add(edge);
        }
        while (q.peek().len != Integer.MAX_VALUE) {
            Edge edge = q.poll();
            for (Road road : edge.roads) {
                if (edge.len + road.length < edges[road.goal].len) {
                    edges[road.goal].len = edge.len + road.length;
                    q.add(edges[road.goal]);
                }
            }
        }
        List<Edge> list = Arrays.asList(edges).stream().filter(e -> e.len == searchLength).sorted((o1, o2) -> o1.index - o2.index).collect(Collectors.toList());
        if(list.isEmpty()) {
            System.out.println(-1);
        }
        else{
            for (Edge edge : list) {
                System.out.println(edge.index);
            }
        }
    }

    private class Edge implements Comparable<Edge> {
        int index;
        int len = Integer.MAX_VALUE;
        List<Road> roads = new ArrayList<>();

        @Override
        public int compareTo(Edge o) {
            return len - o.len;
        }

        public Edge(int index) {
            this.index = index;
        }

        public void addRoad(int index, int length) {
            roads.add(new Road(this.index, index, length));
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "index=" + index +
                    ", len=" + len +
                    ", roads=" + roads +
                    '}';
        }
    }

    private class Road {
        int start;
        int goal;
        int length;

        public Road(int start, int goal, int length) {
            this.start = start;
            this.goal = goal;
            this.length = length;
        }
    }
}
