import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            char[] order = new char[N];
            int[] btn = new int[N];

            for (int i = 0; i < N; i++) {
                order[i] = st.nextToken().charAt(0);
                btn[i] = Integer.parseInt(st.nextToken());
            }

            int time = btn[0];
            int bIdx = 1;
            int oIdx = 1;
            if (order[0] == 'B') {
                bIdx = btn[0];
            } else {
                oIdx = btn[0];
            }
            int timer = btn[0];

            for (int i = 1; i < N; i++) { // i번째 로봇이 버튼을 누르는 연산
                if (order[i - 1] == order[i]) { // 같은 로봇이 연달아 버튼을 누를 때
                    int dff = Math.abs(btn[i] - btn[i - 1]);
                    time += (dff + 1); // 이동 시간 + 버튼 누른 시간
                    timer += (dff + 1); // 추가로 소요한 시간 (다른 로봇이 이동할 수 있는 시간)

                    if (order[i] == 'B') {
                        bIdx = btn[i]; // 현위치 업데이트
                    } else {
                        oIdx = btn[i];
                    }
                } else { // 다른 로봇이 버튼을 눌러야 할 때
                    if (order[i] == 'B') {
                        int diff = Math.abs(bIdx - btn[i]);
                        if (timer >= diff) { // 이동할 수 있는 시간이 더 많을 때
                            time++; // 버튼 누르는 시간만 추가해주면 됨
                            timer = 1;
                        } else {
                            int add = (diff - timer + 1);
                            time += add;
                            timer = add;
                        }
                        bIdx = btn[i]; // 위치 업데이트
                    } else {
                        int diff = Math.abs(oIdx - btn[i]);
                        if (timer >= diff) { // 이동할 수 있는 시간이 더 많을 때
                            time++; // 버튼 누르는 시간만 추가해주면 됨
                            timer = 1;
                        } else {
                            int add = (diff - timer + 1);
                            time += add;
                            timer = add;
                        }
                        oIdx = btn[i]; // 위치 업데이트
                    }
                }


            }


            sb.append("#").append(test).append(" ").append(time).append("\n");
        }
        System.out.println(sb.toString());
    }
}
