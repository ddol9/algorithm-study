import java.io.*;
import java.util.*;

public class Main {

    static int N, M, H;
    static int[][][] tomato;
    static Queue<int[]> q = new LinkedList<>();
    static int tCount;

    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[N][M][H];
        tCount = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    tomato[j][k][i] = Integer.parseInt(st.nextToken());
                    if (tomato[j][k][i] == 1) {
                        q.add(new int[]{j, k, i, 0});
                    } else if (tomato[j][k][i] == 0) {
                        tCount++;
                    }
                }
            }
        }

        int result = bfs();
        if (tCount != 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        int maxDay = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int h = current[2];
            int day = current[3];

            if (day > maxDay) {
                maxDay = day;
            }

            for (int i = 0; i < 6; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int nh = h + dh[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H) continue;
                if (tomato[nr][nc][nh] == 0) {
                    tomato[nr][nc][nh] = 1;
                    tCount--;
                    q.add(new int[]{nr, nc, nh, day + 1});
                }
            }
        }
        return maxDay;
    }
}
