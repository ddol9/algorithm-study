import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int ts = 1; ts <= T; ts++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] deg = new int[N + 1];
            int[] cost = new int[N + 1];
            int[] t = new int[N + 1];
            List<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }


            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                deg[b]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (deg[i] == 0) {
                    t[i] = cost[i];
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int prev = q.poll();
                for (int next : graph[prev]) {
                    t[next] = Math.max(t[next], t[prev] + cost[next]);
                    if (--deg[next] == 0) q.add(next);
                }
            }
            int W = Integer.parseInt(br.readLine());
            System.out.println(t[W]);
        }

    }
}
