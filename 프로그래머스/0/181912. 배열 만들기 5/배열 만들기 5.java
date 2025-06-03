class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int count = 0;
        for (String str : intStrs) {
            int num = Integer.parseInt(str.substring(s, s + l));
            if (num > k) {
                count++;
            }
        }

        int[] answer = new int[count];
        int idx = 0;
        for (String str : intStrs) {
            int num = Integer.parseInt(str.substring(s, s + l));
            if (num > k) {
                answer[idx++] = num;
            }
        }

        return answer;
    }
}