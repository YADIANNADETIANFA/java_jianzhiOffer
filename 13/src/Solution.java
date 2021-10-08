
public class Solution {
    public static int movingCount(int threshold, int rows ,int cols) {
        int[][] tempArray = new int[rows][cols];    //辅助数组
        return getCountCore(threshold, rows, cols, 0, 0, tempArray);
    }

    public static int getCountCore(int threshold, int rows, int cols, int i, int j, int[][] tempArray) {
        if (i >= rows || j >= cols || i < 0 || j < 0) {
            return 0;
        }
        if (tempArray[i][j] == -1) {
            return 0;
        }
        int count = getSum(i) + getSum(j);
        int res = 0;
        if (count <= threshold) {
            tempArray[i][j] = -1;
            res = 1 + getCountCore(threshold, rows, cols, i - 1, j, tempArray)
                    + getCountCore(threshold, rows, cols, i + 1, j, tempArray)
                    + getCountCore(threshold, rows, cols, i, j - 1, tempArray)
                    + getCountCore(threshold, rows, cols, i, j + 1, tempArray);
        }
        return res;
    }

    public static int getSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num = num / 10;
        }
        return res;
    }
}
