import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 수열의 개수
        int S = Integer.parseInt(st.nextToken()); // 합이 S 이상

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (true) {
            if (sum >= S) {
                minLen = Math.min(minLen, R - L);
                sum -= arr[L];
                L++;
            } else {
                if (R == N) break;
                sum += arr[R];
                R++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        System.out.println(minLen);

    }

}