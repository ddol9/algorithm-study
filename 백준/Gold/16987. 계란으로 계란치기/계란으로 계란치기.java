import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] str;
    static int[] weight;
    static int maxCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            str[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        egg(0);
        System.out.println(maxCnt);

    }

    static void egg(int idx) {
        if (idx == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (str[i] <= 0) cnt++;
            }
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }

        if (str[idx] <= 0) {
            egg(idx + 1);
            return;
        }

        boolean flag = false;

        for (int i = 0; i < N; i++) {

            if (i != idx && str[i] > 0) {
                flag = true;
                str[idx] -= weight[i];
                str[i] -= weight[idx];

                egg(idx + 1);

                str[idx] += weight[i];
                str[i] += weight[idx];
            }
        }

        if (!flag) {
            egg(idx + 1);
        }
    }
}
