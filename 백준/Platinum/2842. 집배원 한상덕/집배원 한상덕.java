import java.io.*;
import java.util.*;

public class Main {

    static int[][] height;
    static int N;
    static char[][] map;
    static int startR, startC;
    static List<int[]> houses;

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 격자 크기

        height = new int[N][N];
        map = new char[N][N];
        startR = -1;
        startC = -1; // 출발 점 좌표
        houses = new ArrayList<>(); // 목적지 좌표 list

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'P') {
                    startR = i;
                    startC = j;
                } else if (c == 'K') {
                    houses.add(new int[]{i, j});
                }
            }
        }

        TreeSet<Integer> heightSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                heightSet.add(height[i][j]);
            }
        }

        List<Integer> unique = new ArrayList<>(heightSet);

        int L = 0;
        int R = 0;
        int answer = Integer.MAX_VALUE;

        while (L < unique.size() && R < unique.size()) {
            int min = unique.get(L);
            int max = unique.get(R);

            if (canVisit(min, max)) {
                answer = Math.min(answer, max - min);
                L ++;
            } else {
                R++;
            }
        }

        System.out.println(answer);

    }

    static boolean canVisit(int min, int max) {
        if (height[startR][startC] < min || height[startR][startC] > max) {
            return false;
        }

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();

        visited[startR][startC] = true;
        q.offer(new int[]{startR, startC});

        int count = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if (map[r][c] == 'K') {
                count++;
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr<0 || nr >= N || nc<0 || nc >= N) continue;
                if (visited[nr][nc]) continue;

                int h = height[nr][nc];
                if (h < min || h > max) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }

        return count == houses.size();
    }

}