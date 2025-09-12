import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] deg = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < s; j++) {
                int next = Integer.parseInt(st.nextToken());
                deg[next]++;
                graph[prev].add(next);
                prev = next;
            }
        }
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (deg[i] == 0) {
                q.add(i);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append("\n");
            for (int next : graph[now]) {
                if (--deg[next] == 0) {
                    q.offer(next);
                    cnt++;
                }
            }
        }
        if (cnt != N) {
            System.out.println(0);
            return;
        }

        System.out.println(sb.toString());
    }
}
