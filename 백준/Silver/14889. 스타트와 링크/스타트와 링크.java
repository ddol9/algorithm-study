import java.io.*;
import java.util.*;

public class Main {
    static int[][] pow;
    static boolean[] teamList;
    static int N;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        pow = new int[N][N];
        teamList = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                pow[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getTeam(0, 0);
        System.out.println(minDiff);
    }

    static void getTeam(int newPlayer, int memNum) {
        if (memNum == N / 2) {
            minDiff = Math.min(minDiff, getPower());
            return;
        }

        if (newPlayer == N) return;

        teamList[newPlayer] = true;
        getTeam(newPlayer + 1, memNum + 1);

        teamList[newPlayer] = false;
        getTeam(newPlayer + 1, memNum);

    }

    static int getPower() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (teamList[i] && teamList[j]) {
                    start += pow[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!teamList[i] && !teamList[j]) {
                    link += pow[i][j];
                }
            }
        }

        return Math.abs(start - link);
    }
}
