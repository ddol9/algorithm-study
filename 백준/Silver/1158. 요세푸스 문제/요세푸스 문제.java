import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;

        while (!list.isEmpty()) {
            index = (index + (M-1)) % list.size();

            if (list.size() == 1) {
                sb.append(list.remove(index));
            } else {
                sb.append(list.remove(index)).append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb.toString());

        scanner.close();
    }
}