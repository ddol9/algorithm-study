import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] nodes;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < N+1; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			nodes[u].add(v);
			nodes[v].add(u);
		}
		
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			if (!visited[i]) {
				bfs(i);
				count++;
			} 
		}
		
		
		System.out.println(count);
	}
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		
		visited[node] = true;
		q.add(node);
		
		while (!q.isEmpty()) {
			int prev = q.poll();
			for (int i = 0; i < nodes[prev].size(); i++) {
				int next = nodes[prev].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
		
	}

}
