import java.io.*;
import java.util.*;

public class Main {

  static int R, C, T;
  static int[][] map;
  static int[][] newmap;
  static int cleaner;

  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    map = new int[R][C];
    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < C; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == -1) {
          cleaner = i; // 공기청정기 위치 저장 (아랫쪽이 최종 저장됨)
        }
      }
    }

    for (int i = 0; i < T; i++) {
      spread();
      clean();
    }

    int sum = 2;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        sum += map[i][j];
      }
    }

    System.out.println(sum);

  }

  static void spread() { // 확산
    newmap = new int[R][C];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] > 0) {
          int divCnt = 0;

          for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
              continue;
            }
            if (map[nr][nc] != -1) {
              newmap[nr][nc] += map[i][j] / 5;
              divCnt++;
            }
          }
          newmap[i][j] += map[i][j] - divCnt * (map[i][j] / 5);
        }
      }
    }

    newmap[cleaner-1][0] = -1;
    newmap[cleaner][0] = -1;

    map = newmap;
  }

  static void clean() {
    newmap = new int[R][C];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (i == 0 || i == R - 1) { // 맨 위, 맨 아래 열 왼쪽으로 이동 (꼭지점 제외)
          if (j != C - 1) {
            newmap[i][j] = map[i][j + 1];
          } else {
            newmap[0][C - 1] = map[1][C - 1];
            newmap[R - 1][C - 1] = map[R - 2][C - 1];
          }
        } else if (i == cleaner || i == cleaner - 1) { // 청정기가 위치한 행 이동
          if (j == 0) {
            newmap[i][j] = -1;
          } else if (j == 1) {
            newmap[i][j] = 0;
          } else {
            newmap[i][j] = map[i][j - 1];
          }
        } else if (j == C - 1 && i > cleaner) {
          newmap[i][j] = map[i - 1][j];
        } else if (j == C - 1 && i < cleaner - 1) {
          newmap[i][j] = map[i + 1][j];
        } else if (j == 0) {
          if (i < cleaner - 1) {
            newmap[i][j] = map[i - 1][j];
          } else if (i > cleaner) {
            newmap[i][j] = map[i + 1][j];
          }
        } else {
          newmap[i][j] = map[i][j];
        }
      }
    }
    map = newmap;
  }

}
