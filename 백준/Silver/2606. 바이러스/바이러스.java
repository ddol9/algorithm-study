import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int V = Integer.parseInt(br.readLine());

    List<Integer>[] list = new List[N + 1];
    for (int i = 0; i < N + 1; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < V; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      list[u].add(v);
      list[v].add(u);
    }

    // bfs -> 큐
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[N + 1];
    q.add(1);
    visited[1] = true;

    int cnt = 0;
    while (!q.isEmpty()) {
      int prev = q.poll();

      for (int i : list[prev]) {
        if (visited[i]) {
          continue;
        }
        q.add(i);
        visited[i] = true;
        cnt++;
      }

    }

    System.out.println(cnt);

  }

}
