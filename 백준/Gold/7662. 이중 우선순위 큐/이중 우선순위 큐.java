import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            for (int i = 0; i < k; i++) {
                String[] operation = br.readLine().split(" ");
                char op = operation[0].charAt(0);
                int n = Integer.parseInt(operation[1]);
                
                if (op == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (op == 'D') {
                    if (!map.isEmpty()) {
                        int target;
                        if (n == 1) {
                            target = map.lastKey();
                        } else {
                            target = map.firstKey();
                        }
                        
                        int count = map.get(target);
                        if (count == 1) {
                            map.remove(target);
                        } else {
                            map.put(target, count - 1);
                        }
                    }
                }
            }
            
            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}