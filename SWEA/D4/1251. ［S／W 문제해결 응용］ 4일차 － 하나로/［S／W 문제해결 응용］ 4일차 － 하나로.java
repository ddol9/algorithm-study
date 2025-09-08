import java.io.*;
import java.util.*;

public class Solution {

    static double E;
    static long[] x;
    static long[] y;

    static int[] parent;
    static int[] rank;

    static class Node implements Comparable<Node> {
        int u, v;
        long sq;

        Node(int u, int v) {
            this.u = u;
            this.v = v;
            long dx = x[u] - x[v];
            long dy = y[u] - y[v];
            this.sq = dx * dx + dy * dy;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.sq, o.sq);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            rank = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            x = new long[N + 1];
            y = new long[N + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                x[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                y[i] = Long.parseLong(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    pq.offer(new Node(i, j));
                }
            }

            double res = 0;
            int eCount = 0;
            while (!pq.isEmpty() && eCount < N - 1) {
                Node current = pq.poll();
                if (union(current.u, current.v)) {
                    eCount++;
                    res += E * current.sq;
                }
            }

            System.out.println("#" + test + " " + Math.round(res));
        }
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