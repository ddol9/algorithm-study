import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 주유소 개수
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); // 주유소까지의 거리
            int b = Integer.parseInt(st.nextToken()); // 채울 수 있는 연료의 양

            list.add(new int[]{a, b});
        }

        list.sort((a, b) -> (a[0] - b[0]));

        st = new StringTokenizer(br.readLine(), " ");
        int L = Integer.parseInt(st.nextToken()); // 위치에서 마을까지의 거리
        int P = Integer.parseInt(st.nextToken()); // 트럭에 기존 연료 양

        int cnt = 0;
        int remain = P;
        int start = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (remain < L) {
            while (start < N && list.get(start)[0] <= remain) {
                pq.offer(list.get(start)[1]);
                start++;
            }

            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }

            remain += pq.poll();
            cnt++;
        }

        System.out.println(cnt);

    }

}