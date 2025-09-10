import java.io.*;
import java.util.*;

public class Main {

    static int N, M, X;
    static int[] dist;
    static int[] revDist;
    static List<int[]>[] edges;
    static List<int[]>[] reverseEdges;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        revDist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(revDist, Integer.MAX_VALUE);

        edges = new ArrayList[N + 1];
        reverseEdges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            reverseEdges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[u].add(new int[]{v, w});
            reverseEdges[v].add(new int[]{u, w});
        }

        dijkstra();
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] + revDist[i] > max) {
                max = dist[i] + revDist[i];
            }
        }
        System.out.println(max);
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.offer(new int[]{X, 0});
        dist[X] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (dist[curr[0]] < curr[1]) continue;

            for (int[] edge : edges[curr[0]]) {
                int next = edge[0];
                int nextDist = edge[1] + curr[1];

                if (dist[next] > nextDist) {
                    dist[next] = nextDist;
                    pq.offer(new int[]{next, nextDist});
                }
            }
        }

        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{X, 0});
        revDist[X] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (revDist[curr[0]] < curr[1]) continue;

            for (int[] edge : reverseEdges[curr[0]]) {
                int next = edge[0];
                int nextDist = edge[1] + curr[1];

                if (revDist[next] > nextDist) {
                    revDist[next] = nextDist;
                    pq.offer(new int[]{next, nextDist});
                }
            }
        }
    }
}
