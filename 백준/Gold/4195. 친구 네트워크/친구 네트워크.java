import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> fmap;
    static int cnt;
    static int[] p;
    static int[] size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            int F = Integer.parseInt(br.readLine());

            fmap = new HashMap<>();
            p = new int[F * 2];
            size = new int[F * 2];
            cnt = 0;

            for (int i = 0; i < F * 2; i++) {
                p[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String a = st.nextToken();
                String b = st.nextToken();

                int na = findMap(a);
                int nb = findMap(b);
                System.out.println(union(na, nb));
            }
        }
    }

    static int findMap(String name) {
        if (fmap.containsKey(name)) return fmap.get(name);
        fmap.put(name, cnt++);
        return cnt - 1;
    }

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static int union(int x, int y) {
        int rX = find(x);
        int rY = find(y);

        if (rX == rY) return size[rX];

        if (size[rX] < size[rY]) {
            p[rX] = rY;
            size[rY] += size[rX];
            return size[rY];
        } else {
            p[rY] = rX;
            size[rX] += size[rY];
            return size[rX];
        }
    }
}
