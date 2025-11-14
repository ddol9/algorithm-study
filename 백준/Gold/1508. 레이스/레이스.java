import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 레이스 트랙 길이
        int M = Integer.parseInt(st.nextToken()); // 심판 수
        int K = Integer.parseInt(st.nextToken()); // 위치 수

        int[] points = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = points[K - 1] - points[0];
        int best = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 1;
            int last = points[0];

            for (int i = 1; i < K; i++) {
                if (points[i] - last >= mid) {
                    cnt++;
                    last = points[i];
                }
            }

            if (cnt >= M) {
                best = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        int last = points[0];
        sb.append('1');

        for (int i = 1; i < K; i++) {
            if (cnt < M && points[i] - last >= best) {
                sb.append('1');
                cnt++;
                last = points[i];
            } else {
                sb.append('0');
            }
        }
        System.out.println(sb.toString());

    }

}