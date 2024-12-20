import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }
        
        int result = 0;
        
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            
            result += a + b;
            pq.add(a+b);
        }
        System.out.println(result);
    }
}
