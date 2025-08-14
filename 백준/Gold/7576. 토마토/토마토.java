import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] box;
    static boolean[][] visited;
    static int count; // 익은 토마토 개수
    static int day;
    static int tomato = 0; // 총 토마토 개수
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) { // 익은 토마토 좌표 설정
                    queue.add(new int[]{i, j, 0});
                }
                if (box[i][j] != -1) {
                    tomato++;
                }
            }
        }

        count += queue.size();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int x = location[0];
            int y = location[1];
            day = location[2];
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (box[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        box[nx][ny] = 1;
                        count++;

                        queue.add(new int[]{nx, ny, day + 1}); // 다음날 익은 토마토 추가
                    }
                }
            }
        }

        if (count == tomato) {
            System.out.println(day);
        } else {
            System.out.println("-1");
        }
    }
}
