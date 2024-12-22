import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        int index = 0;

        while (!list.isEmpty()) {
            index = (index + (K-1)) % list.size();
            if (list.size() == 1) {
                result.append(list.remove(index));
            } else {
                result.append(list.remove(index)).append(", ");
            }
        }

        result.append(">");
        System.out.println(result.toString());

        sc.close();
    }
}