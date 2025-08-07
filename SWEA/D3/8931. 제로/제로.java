import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            int K = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= K; i++) {
                int prev = Integer.parseInt(br.readLine());
                if (prev != 0) {
                    list.add(prev);
                } else {
                    list.remove(list.size() - 1);
                }
            }
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }

            sb.append("#").append(test).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}