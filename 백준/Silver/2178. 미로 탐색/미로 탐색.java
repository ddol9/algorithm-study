import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    //지도 초기화
    int[][] map = new int[N][M];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.println(maze(map));
  }

  static int maze(int[][] map) {
    boolean[][] visited = new boolean[N][M];
    Queue<Point> q = new LinkedList<>();
    visited[0][0] = true;
    q.add(new Point(0, 0, 1));

    while (!q.isEmpty()) {
      Point p = q.poll();

      if (p.x == N - 1 && p.y == M - 1) {
        return p.dist;
      }

      for (int k = 0; k < 4; k++) {
        int x = p.x + dx[k];
        int y = p.y + dy[k];

        if (x >= 0 && y >= 0 && x < N && y < M) {
          if (!visited[x][y] && map[x][y] == 1) {
            visited[x][y] = true;
            q.add(new Point(x, y, p.dist + 1));
          }
        }
      }
    }

    return -1;
  }

}

class Point {

  int x;
  int y;
  int dist;

  Point(int x, int y, int dist) {
    this.x = x;
    this.y = y;
    this.dist = dist;
  }
}