import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int count0, count1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count0 = 0;
        count1 = 0;

        searchColor(0, 0, N);
        System.out.println(count0);
        System.out.println(count1);
    }

    static void searchColor(int r, int c, int N) {

        if (isColor(r, c, N) == -1) {
            searchColor(r, c, N / 2);
            searchColor(r, c + N / 2, N / 2);
            searchColor(r + N / 2, c, N / 2);
            searchColor(r + N / 2, c + N / 2, N / 2);
        } else {
            if (isColor(r, c, N) == 0) count0++;
            else count1++;
        }
    }

    static int isColor(int r, int c, int N) {
        int flag = map[r][c];
        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (map[i][j] != flag) return -1;
            }
        }
        return flag;
    }
}
