import java.io.*;
import java.util.*;

public class Main {

  static List<Integer>[] graph;
  static List<Integer> result;
  static int N, M, K, X;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    graph = new List[N + 1];
    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u].add(v);
    }

    findDist();

    if (result.isEmpty()) {
      System.out.println(-1);
    } else {
      Collections.sort(result);
      for (int city : result) {
        System.out.println(city);
      }
    }
  }

  static void findDist() {
    result = new ArrayList<>();
    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
    dist[X] = 0;
    pq.offer(new Node(X, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.w > dist[cur.v]) {
        continue;
      }

      for (int next : graph[cur.v]) {
        int newDist = dist[cur.v] + 1;

        if (newDist < dist[next]) {
          dist[next] = newDist;
          pq.offer(new Node(next, newDist));
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      if (dist[i] == K) {
        result.add(i);
      }
    }
  }

}

class Node {

  int v, w;

  public Node(int v, int w) {
    this.v = v;
    this.w = w;
  }
}
