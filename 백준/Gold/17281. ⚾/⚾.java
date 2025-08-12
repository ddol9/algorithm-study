import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] hit; // 이닝 별 점수를 저장하는 배열
    static int[] turn = new int[9]; // 선수 순서를 저장하는 배열
    static boolean[] isTurn = new boolean[9]; // 선수의 순서가 정해졌는지 확인하는 배열
    static int maxScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        hit = new int[N][9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                hit[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1번 선수 -> 4번 타자에 고정
        turn[3] = 0;
        isTurn[0] = true;

        makeTeam(0);
        System.out.println(maxScore);
    }

    // turn에 dfs로 선수 번호 조합
    static void makeTeam(int idx) {
        if (idx == 9) { // turn의 idx가 8이 넘어가면 선수 배열이 완성되었으므로 return
            maxScore = Math.max(maxScore, getScore());
            return;
        }

        if (idx == 3) { // 4번 타자는 이미 결정되어 있으므로 다음 idx로 pass
            makeTeam(idx + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!isTurn[i]) { // 만약 순서가 결정되지 않은 선수가 있다면
                turn[idx] = i;
                isTurn[i] = true;
                makeTeam(idx + 1);

                //백트래킹
                isTurn[i] = false;
            }

        }

    }

    // 선수 조합이 정해졌을 때의 점수 계산
    static int getScore() {
        int idx = 0; // 몇 번째 타자인지 확인하는 인덱스
        int score = 0; // 총 점수를 저장하는 변수

        for (int inning = 0; inning < N; inning++) { // N번 이닝 반복
            int outCnt = 0;
            boolean[] base = new boolean[4]; // 각 베이스에 선수가 있는지 확인

            while (outCnt < 3) { // 한 이닝 당 아웃카운트가 3이 될 때까지 반복
                int playerNum = turn[idx];
                int hitScore = hit[inning][playerNum];

                if (hitScore == 0) {
                    outCnt++;
                } else if (hitScore == 4) { // 홈런인 경우 베이스의 모든 주자들이 득점
                    for (int i = 1; i < base.length; i++) {
                        if (base[i]) {
                            score++;
                            base[i] = false; // 베이스 초기화
                        }
                    }
                    score++; // 타자도 한 번 더 득점
                } else {
                    for (int i = 3; i > 0; i--) { // base배열을 돌면서 출루한 선수들 진루
                        if (base[i]) {
                            int newBase = i + hitScore;
                            if (newBase > 3) {
                                score++;
                            } else {
                                base[newBase] = true;
                            }
                            base[i] = false; // 원래 주자가 있던 자리는 비워둠
                        }
                    }
                    base[hitScore] = true;
                }
                idx = (idx + 1) % 9;
            }
        }
        return score;
    }
}