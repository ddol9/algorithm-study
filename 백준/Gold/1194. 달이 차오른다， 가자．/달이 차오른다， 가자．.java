import java.io.*;
import java.util.*;

public class Main {

  static char[][] map;
  static boolean[][][] visited;
  static int N, M;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    visited = new boolean[N][M][64]; // 열쇠 종류 6개 -> 2^6

    Queue<Loc> q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j);
        if (line.charAt(j) == '0') { // 출발점 탐색
          q.add(new Loc(i, j, 0, 0)); // 출발점을 큐에 추가
          visited[i][j][0] = true;
        }
      }
    }

    while (!q.isEmpty()) {
      Loc prev = q.poll();
      int pr = prev.r;
      int pc = prev.c;
      int pd = prev.dist;

      if (map[pr][pc] == '1') {
        System.out.println(pd);
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nr = pr + dr[i];
        int nc = pc + dc[i];
        int newKeyMask = prev.keyMask;

        // 범위 체크
        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
          continue;
        }

        // 벽 체크
        if (map[nr][nc] == '#') {
          continue;
        }

        // 문 체크 (A~F)
        if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
          int needKey = map[nr][nc] - 'A';
          // 해당 열쇠가 없으면 못 지나감
          if ((prev.keyMask & (1 << needKey)) == 0) {
            continue;
          }
        }

        // 열쇠 체크 (a~f)
        if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
          int keyIndex = map[nr][nc] - 'a';
          newKeyMask |= (1 << keyIndex); // 열쇠 추가
        }

        // 이미 방문한 상태면 스킵
        if (visited[nr][nc][newKeyMask]) {
          continue;
        }

        // 새로운 상태 추가
        visited[nr][nc][newKeyMask] = true;
        q.add(new Loc(nr, nc, pd + 1, newKeyMask));
      }
    }

    System.out.println(-1);
  }
}

class Loc {

  int r, c, dist, keyMask;

  Loc(int r, int c, int dist, int keyMask) {
    this.r = r;
    this.c = c;
    this.dist = dist;
    this.keyMask = keyMask;
  }
}
