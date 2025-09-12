import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        parent[1] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : graph[current]) {
                if (parent[next] == 0) {
                    parent[next] = current;
                    q.offer(next);
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }
}
