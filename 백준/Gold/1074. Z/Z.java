import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    System.out.println(calcZ(N, r, c));

  }

  static int calcZ(int N, int r, int c) {
    if (N == 0) {
      return 0;
    }

    int half = (int) Math.pow(2, N - 1);
    int size = half * half;

    if (r < half && c < half) {
      return calcZ(N - 1, r, c);
    }
    else if (r < half && c >= half) {
      return size + calcZ(N - 1, r, c - half);
    }
    else if (r >= half && c < half) {
      return size * 2 + calcZ(N - 1, r - half, c);
    }
    else {
      return size * 3 + calcZ(N - 1, r - half, c - half);
    }

  }

}
