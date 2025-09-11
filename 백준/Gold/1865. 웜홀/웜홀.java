import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static List<Edge>[] graph;
    static int N;
    static int[] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine(), " ");
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph[S].add(new Edge(E, T));
                graph[E].add(new Edge(S, T));
            }

            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine(), " ");
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph[S].add(new Edge(E, -T));
            }

            d = new int[N + 1];

            for (int cyc = 1; cyc < N; cyc++) {
                for (int j = 1; j <= N; j++) {
                    for (Edge next : graph[j]) {
                        if (d[next.v] > d[j] + next.w) {
                            d[next.v] = d[j] + next.w;
                        }
                    }
                }
            }

            boolean flag = false;
            for (int j = 1; j <= N; j++) {
                for (Edge next : graph[j]) {
                    if (d[next.v] > d[j] + next.w) {
                        flag = true;
                        break;
                    }
                }
            }

            System.out.println(flag ? "YES" : "NO");

        }


    }
}
