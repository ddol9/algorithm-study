import java.io.*;
import java.util.*;

public class Main {

    static long[] d;
    static int N;

    static class Edge {
        int v;
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        d = new long[N + 1];
        Arrays.fill(d, Long.MAX_VALUE);

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Edge(B, C));
        }

        d[1] = 0;
        for (int cyc = 0; cyc < N; cyc++) {
            boolean updated = false;
            for (int i = 1; i <= N; i++) {
                if (d[i] == Long.MAX_VALUE) continue;
                for (Edge next : graph[i]) {
                    if (d[next.v] > d[i] + next.w) {
                        d[next.v] = d[i] + next.w;
                        updated = true;
                    }
                }
            }
            if (!updated) break;
        }

        for (int i = 1; i <= N; i++) {
            if (d[i] == Long.MAX_VALUE) continue;
            for (Edge next : graph[i]) {
                if (d[next.v] > d[i] + next.w) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (d[i] == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(d[i]);
            }
        }
    }
}