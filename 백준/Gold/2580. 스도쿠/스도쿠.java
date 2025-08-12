import java.io.*;
import java.util.*;


public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setNum();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean setNum() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) { // 빈칸 탐색
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(i, j, num)) { // 빈칸에 숫자 하나씩 대입
                            map[i][j] = num; // 맞으면 추가
                            if (setNum()) return true;
                            map[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(int r, int c, int num) {
        //가로 탐색
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == num) return false;
        }

        //세로 탐색
        for (int i = 0; i < 9; i++) {
            if (map[i][c] == num) return false;
        }

        //팔방 탐색
        for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
            for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }

        return true;
    }
}
