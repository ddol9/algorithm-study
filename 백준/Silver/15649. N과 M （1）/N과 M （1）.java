import java.io.*;
import java.util.*;

public class Main {

    static int[] nums;
    static int[] result;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        result = new int[M];
        dfs(0);

        System.out.println(sb.toString());

    }

    static void dfs(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < cnt; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                result[cnt] = i;

                dfs(cnt + 1);
                nums[i] = 0;
            }
        }
    }
}
