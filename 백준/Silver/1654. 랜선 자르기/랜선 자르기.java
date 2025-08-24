import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] lines = new int[N];
    long start = 1;
    long end = 0;

    for (int i = 0; i < N; i++) {
      lines[i] = Integer.parseInt(br.readLine());
      if (lines[i] > end) {
        end = lines[i];
      }
    }

    long result = 0;

    while (start <= end) {
      long mid = (start + end) / 2;

      long count = 0;
      for (int i = 0; i < N; i++) {
        count += lines[i] / mid;
      }

      if (count >= K) {
        result = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    System.out.println(result);
  }
}