import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int u, v, w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) { // 가중치 오름차순
            return Integer.compare(this.w, o.w);
        }
    }

    static int min;
    static int[] parent;
    static int[] rank;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        rank = new int[V + 1];


        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Node n = new Node(u, v, w);
            pq.offer(n);
        }

        min = 0;
        int eCount = 0;

        while (!pq.isEmpty() && eCount < V - 1) {
            Node current = pq.poll();

            if (union(current.u, current.v)) {
                min += current.w;
                eCount++;
            }
        }

        System.out.println(min);

    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int x, int y) {
        int rX = find(x);
        int rY = find(y);

        if (rX == rY) {
            return false;
        }

        if (rank[rX] > rank[rY]) {
            parent[rY] = rX;
        } else {
            parent[rX] = rY;
            if (rank[rX] == rank[rY]) {
                rank[rY]++;
            }
        }
        return true;
    }
}
