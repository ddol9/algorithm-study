import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[] minVal = new int[N + 1];

    minVal[0] = 0;
    minVal[1] = 0;

    for (int i = 2; i <= N; i++) {
      minVal[i] = minVal[i - 1] + 1;
      if (i % 2 == 0) {
        minVal[i] = Math.min(minVal[i], minVal[i / 2] + 1);
      }
      if (i % 3 == 0) {
        minVal[i] = Math.min(minVal[i], minVal[i / 3] + 1);
      }

    }
    System.out.println(minVal[N]);
  }
}
