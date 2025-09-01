import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] sets;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sets = new int[M];

		findSet(0);

		System.out.println(sb.toString());
	}

	static void findSet(int cnt) {
		if (cnt == M) { // 카운트가 M에 도달하면 재귀 중단
			for (int i = 0; i < M; i++) {
				sb.append(sets[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			sets[cnt] = i;
			findSet(cnt + 1);
		}

	}
}
