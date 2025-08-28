import java.io.*;
import java.util.*;

class Solution {
    static int[][] burger;
    static int max;
    static int N, L;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 재료 개수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            burger = new int[N][2];
            max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                burger[i][0] = Integer.parseInt(st.nextToken());
                burger[i][1] = Integer.parseInt(st.nextToken());
            }

            findMax(0, 0, 0);
            System.out.println("#"+test_case+" "+max);

        }
    }

    static void findMax(int idx, int score, int cal) {
        if (cal > L) return;
        if (idx == N) {
            if (score > max) max = score;
            return;
        }

        findMax(idx + 1, score + burger[idx][0], cal + burger[idx][1]);
        findMax(idx + 1, score, cal);

    }
}