import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st1 = br.readLine();
        String st2 = br.readLine();

        int[][] lcs = new int[st1.length() + 1][st2.length() + 1];

        int max = 0;

        for (int i = 1; i < st1.length() + 1; i++) {
            for (int j = 1; j < st2.length() + 1; j++) {
                if (st1.charAt(i - 1) == st2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
                max = Math.max(max, lcs[i][j]);
            }
        }
        System.out.println(max);

        StringBuilder sb = new StringBuilder();
        int i = st1.length(), j = st2.length();
        while (i > 0 && j > 0) {
            if (st1.charAt(i - 1) == st2.charAt(j - 1)) {
                sb.append(st1.charAt(i - 1));
                i--;
                j--;
            } else if (lcs[i][j - 1] >= lcs[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }

        System.out.println(sb.reverse().toString());
    }
}
