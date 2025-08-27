import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static long[] tree;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tree = new long[4 * N];
        init(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long result = findMin(1, 0, N - 1, a - 1, b - 1);
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void init(int node, int start, int end) { // tree 초기화 함수
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            init(2 * node, start, mid);
            init(2 * node + 1, mid + 1, end);
            tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);

        }
    }

    static long findMin(int node, int start, int end, int l, int r) {
        // 범위 안에 들어가는지 확인
        if (r < start || end < l) return Long.MAX_VALUE;
        if (l <= start && r >= end) return tree[node];

        int mid = (start + end) / 2;
        long left = findMin(2 * node, start, mid, l, r);
        long right = findMin(2 * node + 1, mid + 1, end, l, r);
        return Math.min(right, left);
    }
}
