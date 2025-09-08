import java.io.*;
import java.util.*;

public class Main {
    static class Coord {
        double x, y;

        Coord(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v;     // 좌표 인덱스 저장
        double w;

        Edge(int u, int v, Coord coordU, Coord coordV) {
            this.u = u;
            this.v = v;
            this.w = Math.sqrt((coordU.x - coordV.x) * (coordU.x - coordV.x) +
                    (coordU.y - coordV.y) * (coordU.y - coordV.y));
        }

        @Override
        public int compareTo(Edge e) {
            return Double.compare(this.w, e.w);
        }
    }

    static int[] parent;
    static int[] rank;
    static Coord[] coords;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        coords = new Coord[n + 1];
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            coords[i] = new Coord(x, y); // 모든 점의 정보 저장
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                pq.offer(new Edge(i, j, coords[i], coords[j])); // 모든 간선 정보 저장
            }
        }

        double res = 0;
        int eCount = 0;
        while (!pq.isEmpty() && eCount < n - 1) {
            Edge current = pq.poll();
            if (union(current.u, current.v)) {
                res += current.w;
                eCount++;
            }
        }

        System.out.printf("%.2f\n", res);
    }

    static int findP(int a) {
        if (parent[a] != a) {
            parent[a] = findP(parent[a]);
        }
        return parent[a];
    }

    static boolean union(int a, int b) {
        int rA = findP(a);
        int rB = findP(b);

        if (rA == rB) return false;
        if (rank[rA] > rank[rB]) {
            parent[rB] = rA;
        } else {
            parent[rA] = rB;
            if (rank[rA] == rank[rB]) {
                rank[rB]++;
            }
        }
        return true;

    }
}
