import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());

    // 우선순위 정보 저장 그래프
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 그래프 초기화
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    int[] inDegree = new int[N + 1];
    int[] times = new int[N + 1];
    int[] result = new int[N + 1];

    // 우선순위 연결된 작업들 저장
    for (int work = 1; work <= N; work++) {
      st = new StringTokenizer(br.readLine(), " ");
      int t = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      times[work] = t;
      inDegree[work] = n;

      for (int i = 0; i < n; i++) {
        int node = Integer.parseInt(st.nextToken());
        graph.get(node).add(work);
      }
    }

    Queue<Integer> q = new LinkedList<>();

    // 진입 차수가 0인 노드 먼저 큐에 저장
    for (int i = 1; i <= N; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
        result[i] = times[i];
      }
    }

    while (!q.isEmpty()) {
      int u = q.poll();

      // 큐에서 꺼낸 노드와 연결된 그래프의 1) 진입 차수 -- 2) 작업 완료 시간 업데이트
      for (int v : graph.get(u)) {
        inDegree[v]--;
        result[v] = Math.max(result[u] + times[v], result[v]);
        if (inDegree[v] == 0) {
          q.add(v);
        }
      }
    }

    int max = 0;
    for (int time : result) {
      if (time > max) {
        max = time;
      }
    }

    System.out.println(max);
  }

}
