import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    scanner.nextLine();
    char[][] board = new char[N][M];

    for (int i = 0; i < N; i++) {
      String line = scanner.nextLine();
      board[i] = line.toCharArray();
    }

    int minResult = Integer.MAX_VALUE;

    for (int startRow = 0; startRow <= N - 8; startRow++) {
      for (int startCol = 0; startCol <= M - 8; startCol++) {

        int wCount = 0;
        // W로 시작하는 경우
        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
            if (i % 2 == 0) {
              if (j % 2 == 1 && board[startRow + i][startCol + j] == 'W') wCount++;
              if (j % 2 == 0 && board[startRow + i][startCol + j] == 'B') wCount++;
            } else {
              if (j % 2 == 0 && board[startRow + i][startCol + j] == 'W') wCount++;
              if (j % 2 == 1 && board[startRow + i][startCol + j] == 'B') wCount++;
            }
          }
        }

        int bCount = 0;
        // B로 시작하는 경우
        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
            if (i % 2 == 0) {
              if (j % 2 == 0 && board[startRow + i][startCol + j] == 'W') bCount++;
              if (j % 2 == 1 && board[startRow + i][startCol + j] == 'B') bCount++;
            } else {
              if (j % 2 == 1 && board[startRow + i][startCol + j] == 'W') bCount++;
              if (j % 2 == 0 && board[startRow + i][startCol + j] == 'B') bCount++;
            }
          }
        }

        int currentMin = Math.min(wCount, bCount);
        minResult = Math.min(minResult, currentMin);
      }
    }

    System.out.println(minResult);
  }
}