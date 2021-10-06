public class Solution {
    public static TreeNode getNextNode (TreeNode root, TreeNode node) throws Exception {
        if (null == root || null == node) {
            throw new Exception("Invalid Input");
        }
        //node存在右子节点
        if (null != node.right) {
            TreeNode res = node.right;
            while (null != res.left) {
                res = res.left;
            }
            return res;
        }
        //node不存在右子节点，且node为左节点
        if (node.parent != null && node.parent.left == node) {
            return node.parent;
        }
        //node不存在右子节点，且node为右节点
        if (node.parent != null) {
            TreeNode temp = node.parent;
            while (temp.parent != null) {
                TreeNode temp2 = temp.parent;
                if (temp2.left == temp) {
                    return temp2;
                } else {
                    temp = temp2;
                }
            }
        }
        return null;    //node本身已经是最后一个节点了
    }
}

/**
 * 1、有右节点，选右节点，然后持续往左走
 * 2、无右节点，若左子节点，选父节点
 *              若右子节点，向上，直至找到其为左子，否则已为最后节点
 * */

