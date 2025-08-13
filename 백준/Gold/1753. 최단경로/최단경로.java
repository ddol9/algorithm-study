import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());


        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        searchMin(start, V);
    }

    static void searchMin(int start, int V) {
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int prevV = node.vertex;
            int prevDist = node.distance;

            if (prevDist > dist[prevV]) continue;

            for (Node next : graph[prevV]) {
                int nextV = next.vertex;
                int nextDist = prevDist + next.distance;

                if (nextDist < dist[nextV]) {
                    dist[nextV] = nextDist;
                    pq.offer(new Node(nextV, nextDist));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }
}

class Node implements Comparable<Node> {
    int vertex, distance;

    Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}
