import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int r, c;
    static int count;
    static int size, eat;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        size = 2;
        eat = 0;
        count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 상어 초기 위치 설정
                    r = i;
                    c = j;
                    map[i][j] = 0;
                }
            }
        }
        babyShark(r, c);
        System.out.println(count);
    }

    static void babyShark(int r, int c) {
        visited = new boolean[N][N]; // 탐색 할 때 마다 초기화

        Queue<Loc> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new Loc(r, c, 0));

        List<Loc> fishes = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Loc loc = q.poll();

            if (loc.dist > min) break;

            for (int i = 0; i < dr.length; i++) {
                int nr = loc.r + dr[i];
                int nc = loc.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == size || map[nr][nc] == 0) {
                        q.add(new Loc(nr, nc, loc.dist + 1));
                    } else if (map[nr][nc] < size && map[nr][nc] > 0) {
                        if (loc.dist + 1 < min) {
                            min = loc.dist + 1;
                            fishes.clear();
                            fishes.add(new Loc(nr, nc, loc.dist + 1));
                        } else if (loc.dist + 1 == min) {
                            fishes.add(new Loc(nr, nc, loc.dist + 1));
                        }
                    }
                }
            }
        }
        if (!fishes.isEmpty()) {
            Collections.sort(fishes, (a, b) -> {
                if (a.r != b.r) return Integer.compare(a.r, b.r);
                return Integer.compare(a.c, b.c);
            });

            Loc fish = fishes.get(0);
            eat++;
            map[fish.r][fish.c] = 0;
            if (eat >= size) { // 상어 사이즈가 커질 수 있는지 확인
                eat = 0;
                size++;
            }
            count += fish.dist;
            babyShark(fish.r, fish.c);
        }
    }
}

class Loc {
    int r, c, dist;

    Loc(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}
