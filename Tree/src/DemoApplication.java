public class DemoApplication {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode4.right = treeNode7;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode6.left = treeNode8;

        Solution solution = new Solution(treeNode1);
        System.out.print("递归前序遍历：");
        for(var item : solution.preRecursionList){
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.print("递归中序遍历：");
        for(var item : solution.inRecursionList){
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.print("递归后序遍历：");
        for(var item : solution.postRecursionList){
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.print("迭代前序遍历：");
        for(var item : solution.preIterationList){
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.print("迭代中序遍历：");
        for(var item : solution.inIterationList){
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.print("迭代后序遍历：");
        for(var item : solution.postIterationList){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

/**
 * 二叉树结构
 *                            1
 *                    2                 3
 *               4                  5        6
 *                 7                       8
 *
 *https://blog.csdn.net/wang454592297/article/details/79472938
 * https://github.com/TimePickerWang/aimed-at-offer/blob/master/java%E6%BA%90%E7%A0%81/TreeInfo.java
 * */
