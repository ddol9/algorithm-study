import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int[][] map;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    int max = Integer.MIN_VALUE;
    int maxCount = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] > max) {
          max = map[i][j];
        }
      }
    }

    for (int i = 0; i < max; i++) {
      if (maxCount < countBlock(i)) {
        maxCount = countBlock(i);
      }
    }
    System.out.println(maxCount);

  }

  static int countBlock(int h) {

    boolean[][] visited = new boolean[N][N];
    // bfs
    Queue<int[]> q = new LinkedList<>();

    int count = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && map[i][j] > h) {
          q.add(new int[]{i, j});
          visited[i][j] = true;

          while (!q.isEmpty()) {
            int[] prev = q.poll();

            for (int k = 0; k < 4; k++) {
              int nr = prev[0] + dr[k];
              int nc = prev[1] + dc[k];

              if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
              }
              if (visited[nr][nc] || map[nr][nc] <= h) {
                continue;
              }
              q.add(new int[]{nr, nc});
              visited[nr][nc] = true;
            }
          }
          count++;
        }
      }
    }
    return count;
  }

}
