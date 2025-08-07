import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();

            int count = 0;

            for (int i = 0; i < line.length(); i++) {
                char temp = line.charAt(i);
                if (temp == '(') {
                    stack.push(temp);
                } else {
                    stack.pop();
                    if (line.charAt(i - 1) == '(') { //레이저인 경우
                        count += stack.size();
                    } else { //그냥 닫는 경우
                        count += 1;
                    }
                }
            }

            sb.append("#").append(test).append(" ").append(count).append("\n");
        }

        // (인경우 스택에 추가
        // )인경우 첫번째 -> 레이저 처리
        // 레이저인 경우 : 스택에 남은 ( 개수만큼 플러스
        // )이 연속으로 나오는 경우 -> 막대처리
        // 레이저가 아닌 경우 : +1

        System.out.println(sb.toString());
    }

}
