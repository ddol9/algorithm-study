import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] inDegree = new int[N + 1];
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int[] semester = new int[N + 1];

    // 초기화
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
      semester[i] = 1;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(u).add(v); // 그래프 연결
      inDegree[v]++; // 진입 차수 추가
    }

    Queue<Integer> q = new LinkedList<>();

    // 1. 진입 차수가 0인 노드를 큐에 모두 추가
    for (int i = 1; i <= N; i++) {
      if (inDegree[i] == 0) {
        q.offer(i);
      }
    }

    // 2. 큐가 빌 때까지 반복
    while (!q.isEmpty()) {
      int currentNode = q.poll();

      // 3. 현재 노드 연결된 모든 진입 차수 감소
      for (int nextNode : graph.get(currentNode)) {
        semester[nextNode] = Math.max(semester[nextNode], semester[currentNode] + 1);
        inDegree[nextNode]--;

        // 4. 진입 차수가 0이 된 정점을 큐에 넣음
        if (inDegree[nextNode] == 0) {
          q.offer(nextNode);
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      System.out.print(semester[i] + " ");
    }


  }

}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Boj14567 {
//
//  static List<Integer>[] adj;
//  static int[] result;
//
//  public static void main(String[] args) throws Exception {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//    int N = Integer.parseInt(st.nextToken());
//    int M = Integer.parseInt(st.nextToken());
//
//    adj = new ArrayList[N + 1];
//    result = new int[N + 1];
//
//    for (int i = 1; i <= N; i++) {
//      adj[i] = new ArrayList<>();
//    }
//
//    for (int i = 0; i < M; i++) {
//      st = new StringTokenizer(br.readLine(), " ");
//      int sub1 = Integer.parseInt(st.nextToken());
//      int sub2 = Integer.parseInt(st.nextToken());
//      adj[sub2].add(sub1);
//    }
//
//    for (int i = 1; i <= N; i++) {
//      calculateSemester(i);
//    }
//
//    for (int i = 1; i <= N; i++) {
//      System.out.print(result[i] + " ");
//    }
//    System.out.println();
//  }
//
//  static int calculateSemester(int sub) {
//    if (result[sub] != 0) {
//      return result[sub];
//    }
//
//    if (adj[sub].isEmpty()) {
//      result[sub] = 1;
//      return 1;
//    }
//
//    int maxSemester = 0;
//    for (int preSub : adj[sub]) {
//      maxSemester = Math.max(maxSemester, calculateSemester(preSub));
//    }
//
//    result[sub] = maxSemester + 1;
//    return result[sub];
//  }
//}