import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] nums;
	static int[] oper;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		oper = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < oper.length; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		btk(1, nums[0]);

		System.out.println(max);
		System.out.println(min);
	}

	static void btk(int idx, int result) {

		if (idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (oper[i] > 0) {
				oper[i]--;

				int newRes = 0;
				if (i == 0) {
					newRes = result + nums[idx];
				} else if (i == 1) {
					newRes = result - nums[idx];
				} else if (i == 2) {
					newRes = result * nums[idx];
				} else if (i == 3) {
					if (result < 0) {
						newRes = -(-result / nums[idx]);
					} else {
						newRes = result / nums[idx];
					}
				}

				btk(idx + 1, newRes);
				oper[i]++;
			}
		}

	}

}
