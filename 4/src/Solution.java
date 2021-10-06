public class Solution {
    public static boolean hasVal(int[][] array, int value) {
        int right = array[0].length - 1;
        int top = 0;
        while (right >= 0 && top < array.length) {
            int arrVal = array[top][right];
            if (value == arrVal) {
                return true;
            } else if (value > arrVal) {
                top++;
            } else {
                right--;
            }
        }
        return false;
    }
}

/*
 * 选取最新二维数组的右上角
 * if(array[][]>searchNum)去掉该列
 * if(array[][]<searchNum)去掉该行
 * 然后获取最新二维数组，回到第一步
 *
 * 选取左上角没办法判断删除某行或某列
 * */
