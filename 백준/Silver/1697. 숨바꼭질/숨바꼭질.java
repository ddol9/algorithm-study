import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        int[] count = new int[100001];
        q.add(N);
        count[N] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();
            if (temp == K) {
                return count[temp] - 1;
            }

            if (temp>0 && count[temp-1]==0) {
                count[temp-1] = count[temp]+1;
                q.add(temp-1);
            }
            if (temp<100000 && count[temp+1]==0) {
                count[temp+1] = count[temp]+1;
                q.add(temp+1);
            }
            if (temp*2 < 100001 && count[temp*2]==0) {
                count[temp*2] = count[temp]+1;
                q.add(temp*2);
            }

        }
        return -1;
    }
}
