import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    while (true) {
      if (map[r][c] == 0) { // 현재 칸이 청소되지 않은 경우
        cnt++; // 청소 횟수 추가
        map[r][c] = 2; // 청소된 칸으로 표시
      }

      // 사방탐색
      int nd = d;
      boolean found = false;

      for (int i = 0; i < 4; i++) {
        nd = (nd + 3) % 4; // 반시계 방향으로 90도 회전
        int nr = r + dr[nd];
        int nc = c + dc[nd];

        // 경계 체크
        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
          continue;
        }

        // 청소되지 않은 빈 칸 발견
        if (map[nr][nc] == 0) {
          r = nr;
          c = nc;
          d = nd;
          found = true;
          break;
        }
      }

      if (!found) {
        int backDir = (d + 2) % 4; // 후진 방향
        int nr = r + dr[backDir];
        int nc = c + dc[backDir];

        // 후진할 곳이 벽이면 종료
        if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1) {
          break;
        }
        r = nr; // 좌표 변경
        c = nc;
      }

    }

    System.out.println(cnt);

  }
}
