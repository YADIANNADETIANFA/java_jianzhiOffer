public class Solution {
    public static int Fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int last1 = 1;
        int last2 = 0;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = last1 + last2;
            last2 = last1;
            last1 = res;
        }
        return res;
    }
}
