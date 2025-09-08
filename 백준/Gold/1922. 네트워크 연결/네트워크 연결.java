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
        public int compareTo(Edge e) {
            return Integer.compare(this.w, e.w);
        }
    }

    static int[] parent;
    static int[] rank;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
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

        int eCount = 0;
        int min = 0;

        while (!pq.isEmpty() && eCount < N - 1) {
            Edge current = pq.poll();

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
