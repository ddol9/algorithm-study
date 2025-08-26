import java.io.*;
import java.util.*;

public class Main {

    static long[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tree = new long[4 * N];
        long[] arr = new long[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        build(arr, 1, 0, N - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int op = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (op == 1) {
                update(1, 0, N - 1, b - 1, c);
            } else if (op == 2) {
                long result = query(1, 0, N - 1, b - 1, (int) (c - 1));
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void build(long[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    static long query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) return 0;

        if (l <= start && r >= end) return tree[node];

        int mid = (start + end) / 2;
        long left = query(2 * node, start, mid, l, r);
        long right = query(2 * node + 1, mid + 1, end, l, r);

        return left + right;
    }

    static void update(int node, int start, int end, int idx, long val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;

            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }
}
