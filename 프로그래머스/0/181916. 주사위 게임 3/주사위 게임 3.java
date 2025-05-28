class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] count = new int[7];
        count[a]++;
        count[b]++;
        count[c]++;
        count[d]++;
        
        int max = 0;
        int p = 0;
        for (int i = 1; i<7; i++) {
            if (count[i] > max) {
                max = count[i];
                p = i;
            }
        }
        
        if (max == 4) {
            return 1111*p;
        }
        
        if (max == 3) {
            int q = 0;
            for (int i = 1; i < 7; i++) {
                if (count[i] ==1) q = i;
            }
            
            return (int) Math.pow(10*p + q, 2);
        }
        
        if (max == 2) {
            int first = 0, second = 0;
            for (int i = 1; i <= 6; i++) {
                if (count[i] == 2) {
                    if (first == 0) first = i;
                    else second = i;
                }
            }
            if (first != 0 && second != 0) {
                return (first + second) * Math.abs(first - second);
            } else {
                int q = 0, r = 0;
                for (int i = 1; i <= 6; i++) {
                    if (count[i] == 1) {
                        if (q == 0) q = i;
                        else r = i;
                    }
                }
                return q * r;
            }
        }

        int min = 7;
        for (int i = 1; i <= 6; i++) {
            if (count[i] == 1 && i < min) min = i;
        }
        return min;
    }
}