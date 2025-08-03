import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();

    Set<String> unheardNames = new HashSet<>();
    for (int i = 0; i < N; i++) {
      unheardNames.add(scanner.next());
    }

    Set<String> unheardUnseenNames = new HashSet<>();

    for (int i = 0; i < M; i++) {
      String unseenName = scanner.next();
      if (unheardNames.contains(unseenName)) {
        unheardUnseenNames.add(unseenName);
      }
    }

    List<String> result = new ArrayList<>(unheardUnseenNames);
    Collections.sort(result);

    System.out.println(result.size());
    for (String name : result) {
      System.out.println(name);
    }

  }
}