import java.util.Scanner;

class Solution {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T = 10;

    for (int test_case = 1; test_case <= T; test_case++) {
      int testNo = sc.nextInt();
      int len = 100;
      int[][] numArr = new int[100][100];

      for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
          numArr[i][j] = sc.nextInt();
        }
      }

      int answer = 0;
      int xSum = 0;
      int xSum2 = 0;

      for (int i = 0; i < len; i++) {
        int rowSum = 0;
        int colSum = 0;

        for (int j = 0; j < len; j++) {
          rowSum += numArr[i][j];
          colSum += numArr[j][i];
        }

        xSum += numArr[i][i];
        xSum2 += numArr[i][len - 1 - i];

        // 최대값 업데이트
        answer = Math.max(answer, Math.max(rowSum, colSum));
      }

      answer = Math.max(answer, Math.max(xSum, xSum2));

      System.out.println("#" + testNo + " " + answer);
    }
    sc.close();
  }
}