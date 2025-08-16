import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<City>[] graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new City(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        PriorityQueue<City> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[A] = 0;
        pq.offer(new City(A, 0));

        while (!pq.isEmpty()) {
            // 가장 거리가 가까운 인접 원소를 pq에서 poll
            City c = pq.poll();

            // 만약 기존 거리보다 이전 노드 + 가중치의 값이 더 작으면 dist 업데이트
            if (visited[c.v]) continue;
            visited[c.v] = true;

            if (c.v == B) break;

            for (City nextC : graph[c.v]) {
                if (!visited[nextC.v] && dist[c.v] + nextC.dist < dist[nextC.v]) {
                    dist[nextC.v] = dist[c.v] + nextC.dist;
                    pq.offer(new City(nextC.v, dist[nextC.v]));
                }
            }

        }
        System.out.println(dist[B]);
    }
}

class City {
    int v, dist;

    City(int v, int dist) {
        this.v = v;
        this.dist = dist;
    }
}