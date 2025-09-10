import java.io.*;
import java.util.*;

public class Main {

	static class Edge {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

	}

	static List<Edge>[] graph;
	static int N, E;
	static int[] dir1, dir2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();

		}

		dir1 = new int[N + 1];// v1 -> 다익
		dir2 = new int[N + 1];// v2 -> 다익
		Arrays.fill(dir1, Integer.MAX_VALUE);
		Arrays.fill(dir2, Integer.MAX_VALUE);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}

		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		System.out.println(findMin(v1, v2));
	}

	static int findMin(int v1, int v2) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		dir1[v1] = 0;
		pq.add(new int[] { v1, 0 });

		while (!pq.isEmpty()) {
			int[] prev = pq.poll();

			int v = prev[0];
			int w = prev[1];

			if (w > dir1[v])
				continue;

			for (Edge e : graph[v]) {
				int nw = w + e.w;
				if (dir1[e.v] > nw) {
				    dir1[e.v] = nw;
				    pq.add(new int[] { e.v, nw });
				}

			}
		}

		pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

		dir2[v2] = 0;
		pq.add(new int[] { v2, 0 });

		while (!pq.isEmpty()) {
			int[] prev = pq.poll();

			int v = prev[0];
			int w = prev[1];

			if (w > dir2[v])
				continue;

			for (Edge e : graph[v]) {
				int nw = w + e.w;
				if (dir2[e.v] > nw) {
				    dir2[e.v] = nw;
				    pq.add(new int[] { e.v, nw });
				}

			}
		}

		int INF = Integer.MAX_VALUE;

		if (dir1[1] == INF || dir1[v2] == INF || dir2[N] == INF || dir2[1] == INF || dir1[N] == INF) {
			return -1;
		}

		int route1 = dir1[1] + dir1[v2] + dir2[N]; // 1 -> v1 -> v2 -> N
		int route2 = dir2[1] + dir1[v2] + dir1[N]; // 1 -> v2 -> v1 -> N

		return Math.min(route1, route2);


	}
}
