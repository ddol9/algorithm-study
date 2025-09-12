import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] dist = new int[N][M];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<Point> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.addFirst(new Point(0, 0));

        while (!dq.isEmpty()) {
            Point cur = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dr[i];
                int ny = cur.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                int nd = dist[cur.x][cur.y] + map[nx][ny];
                if (nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;
                    Point p = new Point(nx, ny);
                    if (map[nx][ny] == 0) {
                        dq.addFirst(p);
                    } else {
                        dq.addLast(p);
                    }
                }
            }
        }

        System.out.println(dist[N - 1][M - 1]);
    }
}
