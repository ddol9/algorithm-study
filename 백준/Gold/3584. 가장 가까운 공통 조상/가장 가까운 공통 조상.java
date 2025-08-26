import java.io.*;
import java.util.*;

public class Main {
    static final int LOG = 14; // N <= 10000이므로 2^14 = 16384 > 10000
    static int N;
    static List<Integer>[] adj;
    static int[][] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            // 초기화
            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }
            parent = new int[N + 1][LOG];
            depth = new int[N + 1];
            boolean[] isNotRoot = new boolean[N + 1];

            // 트리 구성
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                adj[A].add(B);
                parent[B][0] = A; // B의 직계 부모는 A
                isNotRoot[B] = true;
            }

            // 루트 찾기
            int root = 1;
            for (int i = 1; i <= N; i++) {
                if (!isNotRoot[i]) {
                    root = i;
                    break;
                }
            }

            // DFS로 깊이 계산
            dfs(root, 0);
            
            for (int k = 1; k < LOG; k++) {
                for (int v = 1; v <= N; v++) {
                    if (parent[v][k - 1] != 0) {
                        parent[v][k] = parent[parent[v][k - 1]][k - 1];
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            System.out.println(findLCA(u, v));
        }
    }

    // DFS로 깊이 계산
    static void dfs(int node, int d) {
        depth[node] = d;
        for (int child : adj[node]) {
            if (depth[child] == 0) { // 아직 방문하지 않은 자식
                dfs(child, d + 1);
            }
        }
    }

    static int findLCA(int u, int v) {
        // u를 더 깊은 노드로 설정
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        // u를 v와 같은 깊이로
        int diff = depth[u] - depth[v];
        for (int i = 0; i < LOG; i++) {
            if ((diff & (1 << i)) != 0) {
                u = parent[u][i];
            }
        }

        if (u == v) return u;

        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[u][i] != 0 && parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }
}