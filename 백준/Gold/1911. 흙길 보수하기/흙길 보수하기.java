import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 웅덩이 개수
        int L = Integer.parseInt(st.nextToken()); // 널빤지 길이

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] pond = new int[2];
            pond[0] = Integer.parseInt(st.nextToken());
            pond[1] = Integer.parseInt(st.nextToken());

            list.add(pond);
        }

        list.sort((a, b) -> (a[0] - b[0]));

        int lastIdx = -1;
        int total = 0;
        // 앞에서부터 깔기?
        for (int[] pond : list) {
            int start = pond[0];
            int end = pond[1];

            if (lastIdx < start) {
                lastIdx = start;
            }

            if (lastIdx >= end) {
                continue;
            }

            int need = end - lastIdx;
            int cnt = (need + L - 1) / L;
            total += cnt;
            lastIdx += cnt * L;
        }

        System.out.println(total);

    }

}