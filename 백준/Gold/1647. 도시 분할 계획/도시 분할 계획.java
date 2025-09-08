import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int N, M;
    static int[] parent;
    static int[] rank;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(u, v, w));
        }

        int total = 0;
        int lastEdge = 0;
        int eCount = 0;

        while (!pq.isEmpty() && eCount < N - 1) {
            Edge current = pq.poll();

            if (union(current.u, current.v)) {
                total += current.w;
                lastEdge = current.w;
                eCount++;
            }
        }

        System.out.println(total - lastEdge);
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

        if (rX == rY) return false;
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
