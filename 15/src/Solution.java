public class Solution {

    public static int firstNumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }

    public static int SecondNumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0) {
                ++count;
            }
            flag = flag << 1;
            //这里循环了32次，循环第31次后flag为-1，循环第32次后flag溢出为0，说明int是32位，flag移至溢出为止
        }
        return count;
    }
}

/*
* firstNumberOf1
*   n与n-1进行位与，会将n最右面的1变为0，其他位不变。所以能进行几次位与，就有几个1
*
* SecondNumberOf1
*   对于负数，右移会进入死循环，所以使用左移
*
* 上述两方法都支持正数负数  符号位的1也算一个1
* 计算机中负数用补码表示
*
* 原 1 1011
* 反 1 0100  根据原码，服符号位不变，数值位取反
* 补 1 0101  根据原码，符号位不变，数值位取反加一
*
* int：上限 (2^31) - 1  下限 -2^31
* long：上限 (2^63) - 1    下限 -2^63
*
* m<<n，m左移n位，最左边n位被丢弃，同时在右面补上n个0
* m>>n，m右移n位，最右边n位被丢弃。若m为正数，同时在左面补n个0；若m为负数，同时在左面补n个1
*
* 相关1：  判断一个数是否是2的正数次方 -> 有且只有一个1 -> n & (n-1) == 0     true/false
* 相关2：  判断1011 -> 1100 需动几位
*           (1) 先异或： 0111
*           (2) 再 n = n & (n - 1) 求1的个数
* */
