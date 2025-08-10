import java.io.*;
import java.util.*;

public class Main {

  static int n, m;
  static int[][] map;
  static boolean[][] visited;
  static int[][] result;
  static int[] dx = {0, 0, -1, 1}; //상하좌우
  static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];

    //출발점 설정
    int x = 0;
    int y = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) { //출발지점 검색
          x = i;
          y = j;
        }
      }
    }

    findPath(x, y);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          result[i][j] = -1;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }


  }

  static void findPath(int x, int y) {
    result = new int[n][m];
    visited = new boolean[n][m];
    Queue<Point> q = new LinkedList<>();
    q.add(new Point(x, y, 0));
    visited[x][y] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (!visited[nx][ny] && map[nx][ny] == 1) {
            visited[nx][ny] = true;
            q.add(new Point(nx, ny, p.dist + 1));
            result[nx][ny] = p.dist + 1;
          }
        }
      }
    }


  }

}

class Point {

  int x, y, dist;

  Point(int x, int y, int dist) {
    this.x = x;
    this.y = y;
    this.dist = dist;
  }
}