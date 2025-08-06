import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int end = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[99][i] == 2) {
                    end = i;
                    break;
                }
            }

            int pX = end;
            int pY = 99;
            while (pY != 0) {
                if (pX > 0 && map[pY][pX - 1] == 1) {
                    while (pX > 0 && map[pY][pX - 1] == 1) {
                        pX--;
                    }
                } else if (pX < 99 && map[pY][pX + 1] == 1) {
                    while (pX < 99 && map[pY][pX + 1] == 1) {
                        pX++;
                    }
                }
                pY--;
            }

            System.out.println("#" + N + " " + pX);
        }
    }
}