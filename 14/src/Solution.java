public class Solution {
    public static int cutRope(int target) {

        if (target == 2) {
            return 2;
        }
        if (target == 3) {
            return 3;
        }

        int[] tempArray = new int[target + 1];
        tempArray[0] = 0;
        tempArray[1] = 1;
        tempArray[2] = 2;
        tempArray[3] = 3;

        for (int i = 4; i <= target; i++) {
            tempArray[i] = i;
            for (int j = 1; j <= i / 2; j++) {  //避免i j值对调后的重复计算
                if (tempArray[i] < tempArray[i - j] * tempArray[j]) {
                    tempArray[i] = tempArray[i - j] * tempArray[j];
                }
            }
        }
        return tempArray[target];
    }
}

/*
* 总长为1 2 3情况特殊，因这三个数字的自身长度要大于分段乘积。4的时候2 * 2刚好等于4。5及以上，分段开始大于自身了，2 * 3 = 6
*
* 或者使用贪婪算法，尽量多的分出3
* */
