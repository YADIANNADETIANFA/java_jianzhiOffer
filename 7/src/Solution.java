public class Solution {
    public static TreeNode getTree(int[] preOrder, int[] inOrder) throws Exception {
        if(preOrder.length == 0 || inOrder.length == 0 || preOrder.length != inOrder.length){
            throw new Exception("Invalid Input");
        }
        int leftBegin = 0;
        int leftEnd = preOrder.length - 1;
        int rightBegin = 0;
        int rightEnd = inOrder.length - 1;
        return getTreeCore(leftBegin, leftEnd, rightBegin, rightEnd, preOrder, inOrder);
    }

    public static TreeNode getTreeCore(int leftBegin, int leftEnd, int rightBegin, int rightEnd, int[] preOrder, int[] inOrder) throws Exception {
        TreeNode root = new TreeNode(preOrder[leftBegin]);
        if (leftBegin == leftEnd && rightBegin == rightEnd) {
            return root;    //仅一个点
        } else if (leftEnd - leftBegin != rightEnd - rightBegin) {
            throw new Exception("Invalid Input");
        }
        int temp = 0;
        int i;
        for (i = rightBegin; i <= rightEnd; ++i) {
            if (inOrder[i] != preOrder[leftBegin]) {
                ++temp;
            } else {
                break;
            }
        }
        if (i > rightEnd) {
            throw new Exception("Invalid Input");
        }
        if (temp != 0) {
            root.left = getTreeCore(leftBegin + 1, leftBegin + temp, rightBegin, rightBegin + temp - 1, preOrder, inOrder); //存在左子树
        }
        if (rightBegin + temp < rightEnd) {
            root.right = getTreeCore(leftBegin + temp + 1, leftEnd, rightBegin + temp + 1, rightEnd, preOrder, inOrder);    //存在右子树
        }
        return root;
    }
}
