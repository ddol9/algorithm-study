import java.io.*;
import java.util.*;

public class Main {

    static int cnt = 0;
    static int K;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, N - 1);
        System.out.println(result);

    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int L = left;
        int R = mid + 1;
        int idx = 0;

        int[] temp = new int[right - left + 1];

        while (L <= mid && R <= right) {
            if (arr[L] <= arr[R]) {
                temp[idx++] = arr[L++];
            } else {
                temp[idx++] = arr[R++];
            }
        }

        while (L <= mid) {
            temp[idx++] = arr[L++];
        }

        while (R <= right) {
            temp[idx++] = arr[R++];

        }

        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
            cnt++;

            if (cnt==K) {
                result = temp[i];
                return;
            }
        }
    }
}
