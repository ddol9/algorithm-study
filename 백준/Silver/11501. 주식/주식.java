import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine(), " ");
      int[] prices = new int[N];
      for (int j = 0; j < N; j++) {
        prices[j] = Integer.parseInt(st.nextToken());
      }

      int prevMax = 0;
      long money = 0;
      for (int j = N - 1; j >= 0; j--) {
        if (prices[j] > prevMax) {
          prevMax = prices[j];
        } else {
          money += (prevMax - prices[j]);
        }
      }
      System.out.println(money);
    }

  }

}
