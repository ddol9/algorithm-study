import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    for (int i = 0; i < N; i++) {
      int x = scanner.nextInt();
      int[] result = calc(x);
      System.out.println(result[0] + " " + result[1]);
    }
  }

  public static int[] calc(int N) {
    if (N == 0) {
      return new int[]{1, 0};
    } else if (N == 1) {
      return new int[]{0, 1};
    }

    int[] zero = new int[N + 1];
    int[] one = new int[N + 1];

    zero[0] = 1;
    zero[1] = 0;
    one[0] = 0;
    one[1] = 1;

    for (int i = 2; i <= N; i++) {
      zero[i] = zero[i-1] + zero[i-2];
      one[i] = one[i-1] + one[i-2];
    }

    return new int[]{zero[N], one[N]};
  }
}