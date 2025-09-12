import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] len = new int[N];
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            len[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            int prev = nums[i];
            for (int j = i + 1; j < N; j++) {
                if (prev < nums[j]) {
                    len[j] = Math.max(len[j], len[i] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, len[i]);
        }
        System.out.println(max);
    }
}
