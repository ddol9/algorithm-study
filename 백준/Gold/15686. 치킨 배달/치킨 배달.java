import java.io.*;
import java.util.*;

public class Main {
    static int N, M, min = Integer.MAX_VALUE;
    static List<int[]> houses, chickens;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 1) {
                    houses.add(new int[]{i, j});
                } else if (value == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        selected = new boolean[chickens.size()];
        findMin(0, 0);

        System.out.println(min);
    }

    static void findMin(int idx, int cnt) {
        if (cnt == M) {
            int totalDistance = 0;

            for (int[] house : houses) {
                int minDistance = Integer.MAX_VALUE;

                for (int i = 0; i < chickens.size(); i++) {
                    if (selected[i]) {
                        int[] chicken = chickens.get(i);
                        int distance = Math.abs(house[0] - chicken[0]) +
                                Math.abs(house[1] - chicken[1]);
                        minDistance = Math.min(minDistance, distance);
                    }
                }
                totalDistance += minDistance;
            }

            min = Math.min(min, totalDistance);
            return;
        }

        if (idx == chickens.size()) {
            return;
        }

        selected[idx] = true;
        findMin(idx + 1, cnt + 1);

        selected[idx] = false;
        findMin(idx + 1, cnt);
    }
}