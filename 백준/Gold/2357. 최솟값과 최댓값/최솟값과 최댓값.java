import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static long[][] tree;
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

        tree = new long[4 * N][2];
        init(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long min = findMin(1, 0, N - 1, a - 1, b - 1);
            long max = findMax(1, 0, N - 1, a - 1, b - 1);
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void init(int node, int start, int end) { // tree 초기화 함수
        if (start == end) {
            tree[node][0] = arr[start];
            tree[node][1] = arr[end];
        } else {
            int mid = (start + end) / 2;
            init(2 * node, start, mid);
            init(2 * node + 1, mid + 1, end);
            tree[node][0] = Math.min(tree[2 * node][0], tree[2 * node + 1][0]);
            tree[node][1] = Math.max(tree[2 * node][1], tree[2 * node + 1][1]);

        }
    }

    static long findMin(int node, int start, int end, int l, int r) {
        // 범위 안에 들어가는지 확인
        if (r < start || end < l) return Long.MAX_VALUE;
        if (l <= start && r >= end) return tree[node][0];

        int mid = (start + end) / 2;
        long left = findMin(2 * node, start, mid, l, r);
        long right = findMin(2 * node + 1, mid + 1, end, l, r);
        return Math.min(right, left);
    }

    static long findMax(int node, int start, int end, int l, int r) {
        // 범위 안에 들어가는지 확인
        if (r < start || end < l) return Long.MIN_VALUE;
        if (l <= start && r >= end) return tree[node][1];

        int mid = (start + end) / 2;
        long left = findMax(2 * node, start, mid, l, r);
        long right = findMax(2 * node + 1, mid + 1, end, l, r);
        return Math.max(right, left);
    }


}
