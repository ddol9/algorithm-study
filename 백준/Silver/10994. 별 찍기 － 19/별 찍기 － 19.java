import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = Integer.parseInt(br.readLine());
        int size = 4 * i - 3;
        char[][] array = new char[size][size];

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                array[j][k] = ' ';
            }
        }

        drawStar(size, 0, array);

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                bw.write(array[j][k]);
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void drawStar(int start, int len, char[][] array) {
        if (start < len) return;

        for (int i = len; i < start; i++) {
            array[len][i] = '*';
            array[i][len] = '*';
            array[start - 1][i] = '*';
            array[i][start - 1] = '*';
        }

        drawStar(start - 2, len + 2, array);
    }
}