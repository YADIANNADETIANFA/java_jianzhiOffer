public class Solution {
    public static double Power(double base, int exponent) throws Exception {

        //特殊情况
        if (base == 0 && exponent <= 0) {
            throw new Exception("Invalid input");
        }
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent == -1) {
            return 1 / base;
        }

        //正常情况
        int absExponent = Math.abs(exponent);   //取绝对值

        double res = base;

        //迭代解决，同10.1题死思路
        for (int i = 2; i <= absExponent; i *= 2) {
            res *= res;
        }

        if ((absExponent & 1) == 1) {
            res *= base;
        }

        if (exponent > 0) {
            return res;
        } else {
            return 1 / res;
        }
    }
}
