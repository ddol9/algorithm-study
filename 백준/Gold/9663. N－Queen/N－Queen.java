import java.io.*;

public class Main {
    static int N;
    static int answer = 0;
    static int[] queens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queens = new int[N];

        setQueen(0);
        System.out.println(answer);
    }

    static void setQueen(int cnt) {
        if (cnt == N) { // 퀸을 N개 모두 배치하면 성공
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isQueen(cnt, i)) {
                queens[cnt] = i;
                setQueen(cnt + 1);
            }
        }

    }

    static boolean isQueen(int r, int c) {
        // 해당 위치에 퀸을 놓을 수 있는지 확인
        // 같은 열에 퀸이 있는지 확인
        for (int i = 0; i < r; i++) {
            if (queens[i] == c) return false;
        }

        // 대각선에 퀸이 있는지 확인
        for (int i = 0; i < r; i++) {
            if (Math.abs(i - r) == Math.abs(queens[i] - c)) return false;
        }
        return true;
    }
}
