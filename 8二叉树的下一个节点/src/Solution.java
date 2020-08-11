public class Solution {
    public static TreeNode getNextNode(TreeNode root, TreeNode node) throws Exception {
        if(root == null || node == null){
            throw new Exception("Invalid Input");
        }
        //node有右子节点,
        if(node.right != null){
            TreeNode temp1 = node.right;
            while(temp1.left != null){
                temp1 = temp1.left;
            }
            return temp1;
        }
        //如果node无右子节点，并且node为其父节点的左子节点
        if(node.parent != null && node.parent.left == node){
            return node.parent;
        }
        //如果node无右子节点，并且node为其父节点的右子节点
        if(node.parent != null){
            TreeNode temp2 = node.parent;
            while(temp2.parent != null){
                TreeNode temp3 = temp2.parent;
                if(temp3.left == temp2){
                    return temp3;
                }else{
                    temp2 = temp3;
                }
            }
        }
        return null;    //node本身已经为最后一个节点了
    }
}

/**
 * 1、有右节点，选右子，然后持续往左走
 * 2、无右子节点，若左子节点，选父节点
 *              若右子节点，向上，直至找到其为左子，否则已为最后节点
 * */