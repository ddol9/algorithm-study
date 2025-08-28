import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        nNm(0, 1);
        System.out.println(sb.toString());
    }

    static void nNm(int cnt, int idx) {
        if (cnt == M) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= N; i++) {
            result[cnt] = i;
            nNm(cnt + 1, i + 1);
        }
    }
}
