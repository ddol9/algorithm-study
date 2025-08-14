import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];
            int maxH = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                if (trees[i] > maxH) {
                    maxH = trees[i];
                }
            }

            int[] grow = new int[N];
            int oddG = 0;
            int evenG = 0;

            for (int i = 0; i < N; i++) {
                grow[i] = maxH - trees[i];
                if (grow[i] != 0) {
                    evenG += grow[i] / 2;
                    oddG += grow[i] % 2;
                }
            }

            int answer = 0;
            if (evenG > oddG) {
                while (Math.abs(oddG - evenG) > 1) {
                    evenG--;
                    oddG += 2;
                }
            }

            if (oddG > evenG) {
                answer = 2 * oddG - 1;
            } else {
                answer = 2 * evenG;
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}