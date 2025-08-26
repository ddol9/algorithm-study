import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int N;
    static int[] depth;
    static int[][] parent;
    static final int LOG = 17;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 노드 정보를 저장할 그래프
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        depth = new int[N + 1];
        parent = new int[N + 1][LOG]; // N <= 50000 이므로 최대 2^16

        // 노드 추가
        for (int n = 0; n < N - 1; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
//            parent[v][0] = u; -> 누가 조상 노드인지 아직 모름
        }

        dfs(1, 0);

        // 노드의 2^n별 조상 노드 탐색 - DP
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= N; i++) {
                if (parent[i][j - 1] != 0) {
                    parent[i][j] = parent[parent[i][j - 1]][j - 1];
                }
            }
        }


        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());

            System.out.println(findLCA(N1, N2));
        }
    }

    static void dfs(int node, int par) {
        if (par == 0) {
            depth[node] = 0;
        } else {
            depth[node] = depth[par] + 1;
        }
        parent[node][0] = par;

        for (int child : graph[node]) {
            if (child != par) {
                dfs(child, node);
            }
        }
    }


    static int findLCA(int a, int b) {
        if (depth[a] < depth[b]) { // 항상 깊이는 a > b로 유지
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];
        for (int i = 0; i < LOG; i++) {
            if ((diff & (1 << i)) != 0) {
                a = parent[a][i];
            }
        }

        if (a == b) return a;

        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[a][i] != 0 && parent[b][i] != parent[a][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }
}
