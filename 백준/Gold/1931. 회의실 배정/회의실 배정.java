import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
      if (a[1] == b[1]) {
        return a[0] - b[0];
      }
      return a[1] - b[1];
    });

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      pq.add(new int[]{u, v});
    }

    int last = 0;
    int count = 0;

    while (!pq.isEmpty()) {
      int[] prev = pq.poll();

      if (prev[0] >= last) {
        last = prev[1];
        count++;
      }
    }

    System.out.println(count);
  }

}
