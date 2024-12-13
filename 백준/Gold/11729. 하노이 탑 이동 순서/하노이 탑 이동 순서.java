import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int)(Math.pow(2, N) - 1)).append('\n');
        hanoi(N, 1, 3, 2);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int end, int sub) {
        if (n == 1) {
            sb.append(start + " " + end + "\n");
            return;
        } else {
            hanoi(n - 1, start, sub, end);
            sb.append(start + " " + end + "\n");
            hanoi(n - 1, sub, end, start);
        }
    }
}
