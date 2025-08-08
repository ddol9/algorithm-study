import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            String line = br.readLine();

            // (나 )가 나왔을때만 공
            // (가 나오면 +1
            // )가 나왔을때 바로 앞이 |일때만 +1
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                char temp = line.charAt(i);
                if (temp == '(') {
                    count++;
                } else if (temp == ')' && line.charAt(i - 1) == '|') {
                    count++;
                }
            }
            sb.append("#").append(test).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
