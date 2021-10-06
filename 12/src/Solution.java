import java.util.ArrayList;

public class Solution {
    public static boolean hasPath(ArrayList<ArrayList<Character>> matrix, int row ,int col, String path) {
        if (null == matrix || null == path || row <1 || col < 1) {
            return false;
        }
        if ("".equals(path)) {
            return true;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (hasPathCore(matrix, row, col, path, i, j ,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(ArrayList<ArrayList<Character>> matrix, int row, int col, String path, int i, int j, int index) {
        if (i >= row || j >= col || i < 0 || j < 0) {
            return false;
        }
        if (matrix.get(i).get(j) != path.charAt(index)) {
            return false;
        }
        if (path.length() - 1 == index) {
            return true;
        }
        //余下情况就是，当前字符并非path的最后一个字符，并且当前字符与matrix相匹配
        boolean res = false;
        char temp = matrix.get(i).get(j);
        matrix.get(i).set(j, '0');  //替换为一个不可能出现的字符，避免走"回头路"
        res = hasPathCore(matrix, row, col, path, i - 1, j, index + 1)
                || hasPathCore(matrix, row, col, path, i + 1, j, index + 1)
                || hasPathCore(matrix, row, col, path, i, j - 1, index + 1)
                || hasPathCore(matrix, row, col, path, i, j + 1, index + 1);
        if (res) {
            return true;
        } else {
            matrix.get(i).set(j, temp);
            return false;
        }
    }
}
