import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stair = Integer.parseInt(br.readLine());
        int[] points = new int[301];
        int[] maxScore = new int[301];

        for (int i = 1; i <= stair; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        maxScore[1] = points[1];
        maxScore[2] = maxScore[1] + points[2];
        for (int i = 3; i <= stair; i++) {
            maxScore[i] = Math.max(maxScore[i - 3] + points[i - 1] + points[i], maxScore[i - 2] + points[i]);
        }

        System.out.println(maxScore[stair]);
    }
}
