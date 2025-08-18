import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

    int total = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          pq.add(findBlock(i, j));
          total++;
        }
      }
    }

    System.out.println(total);
    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }
  }

  static int findBlock(int r, int c) {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{r, c});
    visited[r][c] = true;
    int cnt = 1;

    while (!q.isEmpty()) {
      int[] p = q.poll();
      for (int i = 0; i < 4; i++) {
        int nr = p[0] + dr[i];
        int nc = p[1] + dc[i];

        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
          continue;
        }
        if (visited[nr][nc] || map[nr][nc] == 0) {
          continue;
        }

        visited[nr][nc] = true;
        q.add(new int[]{nr, nc});
        cnt++;
      }
    }
    return cnt;
  }

}
