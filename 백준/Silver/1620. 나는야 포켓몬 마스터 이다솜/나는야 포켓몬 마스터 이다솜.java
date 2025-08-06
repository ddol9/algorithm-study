import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> dictName = new HashMap<>();
        Map<Integer, String> dictNum = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            dictName.put(name, i);
            dictNum.put(i, name);
        }

        for (int i = 1; i <= M; i++) {
            String input = br.readLine();
            if (input.charAt(0)>='A' && input.charAt(0)<='Z') {
                System.out.println(dictName.get(input));
            } else {
                System.out.println(dictNum.get(Integer.parseInt(input)));
            }
        }
    }
}
