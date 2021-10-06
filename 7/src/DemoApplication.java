public class DemoApplication {
    public static void main(String[] args) {
        int[] preOrder = new int[]{1,2,4,7,3,5,6,8};
        int[] inOrder = new int[]{4,7,2,1,5,3,8,6};
        try {
            TreeNode root = Solution.getTree(preOrder, inOrder);
            System.out.println("...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


/**
 *                                                  1
 *                                             2          3
 *                                          4          5     6
 *                                           7             8
 *自实现算法，有待后续考察
 * */
