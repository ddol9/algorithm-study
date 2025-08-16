import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[][] minPrice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCnt = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                return;
            testCnt++;

            map = new int[N][N];
            visited = new boolean[N][N];
            minPrice = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 시작점 출발,
            // 전체 이차원 배열 시작점 제외 최소값 max로 초기화
            for (int i = 0; i < N; i++) {
                Arrays.fill(minPrice[i], Integer.MAX_VALUE);
            }
            minPrice[0][0] = map[0][0];

            // Point 저장하는 우선순위 큐 선언
            PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
            // 큐에 시작점 offer
            pq.offer(new Point(0, 0, map[0][0]));

            // 큐에서 가장 거리가 인접한 점 poll = prev
            while (!pq.isEmpty()) {
                Point p = pq.poll();

                // 도착점에 도달했거나, 기존 최솟값보다 이미 커지면 중단
                if (p.r == N - 1 && p.c == N - 1) continue;
                if (visited[p.r][p.c]) continue;
                visited[p.r][p.c] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = p.r + dx[i];
                    int ny = p.c + dy[i];

                    // prev에서 탐색 가능한 노드 찾기
                    // 방문하지 않았음 && prev.거리 + 탐색 노드 거리 < 탐색 노드 기존 값 이면 min값 업데이트
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (!visited[nx][ny] && p.dist + map[nx][ny] < minPrice[nx][ny]) {
                            minPrice[nx][ny] = p.dist + map[nx][ny];
                            pq.offer(new Point(nx, ny, p.dist + map[nx][ny]));
                        }
                    }
                }
            }

            System.out.println("Problem " + testCnt + ": " + minPrice[N - 1][N - 1]);
        }

    }

}

class Point {
    int r, c, dist;

    Point(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}