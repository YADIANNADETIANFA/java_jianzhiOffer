public class Solution {
    public static void printNum(int n) {
        if (n < 1) {
            return;
        }

        //初始化字符数组全为0
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '0';
        }

        double maxNum = Math.pow(10, n);
        for (int i = 0; i < maxNum; i++) {

            //考虑进位
            int j = n - 1;
            while (chars[j] - '0' == 9 && j > 0) {
                chars[j] = '0';
                --j;
            }

            if (j != 0 || (chars[j] != '9')) {
                chars[j] = (char) (chars[j] - '0' + 49);    //字符'0'的ASCII值为48
                //打印，且0099会输出为99，去掉首零
                int k = 0;
                while (k < n) {
                    if (chars[k] == '0') {
                        ++k;
                    } else {
                        break;
                    }
                }
                for (; k < n; k++) {
                    System.out.print(chars[k]);
                }
                //换行
                System.out.println("");
            }
        }
    }
}
