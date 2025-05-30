import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        star(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void star(int row, int col, int N, boolean blank) {
        if (blank) {
            for (int i = row; i < row + N; i++) {
                for (int j = col; j < col + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N ==1) {
            arr[row][col] = '*';
            return;
        }

        int size = N/3;
        int count = 0;
        for (int i = row; i < row + N; i += size) {
            for (int j = col; j < col + N; j += size) {
                count++;
                if (count == 5) {
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }
}