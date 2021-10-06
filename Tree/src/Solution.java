import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> preRecursionList;
    public ArrayList<Integer> inRecursionList;
    public ArrayList<Integer> postRecursionList;

    public ArrayList<Integer> preIterationList;
    public ArrayList<Integer> inIterationList;
    public ArrayList<Integer> postIterationList;

    Solution(TreeNode treeNode) {
        preRecursionList = new ArrayList<>();
        inRecursionList = new ArrayList<>();
        postRecursionList = new ArrayList<>();

        preIterationList = new ArrayList<>();
        inIterationList = new ArrayList<>();
        postIterationList = new ArrayList<>();

        preRecursion(treeNode);
        inRecursion(treeNode);
        postRecursion(treeNode);

        preIteration(treeNode);
        inIteration(treeNode);
        postIteration(treeNode);
    }

    private void preRecursion(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        preRecursionList.add(treeNode.val);
        preRecursion(treeNode.left);
        preRecursion(treeNode.right);
    }

    private void inRecursion(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inRecursion(treeNode.left);
        inRecursionList.add(treeNode.val);
        inRecursion(treeNode.right);
    }

    private void postRecursion(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        postRecursion(treeNode.left);
        postRecursion(treeNode.right);
        postRecursionList.add(treeNode.val);
    }

    private void preIteration(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (null != treeNode) {
                preIterationList.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    private void inIteration(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (null != treeNode) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                inIterationList.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }

    private void postIteration(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (null != treeNode || !stack.isEmpty()) {
            while (null != treeNode) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            boolean tag = true;
            TreeNode preNode = null;    //上一次访问的节点
            while (!stack.isEmpty() && tag) {
                treeNode = stack.peek();    //获取栈顶元素，但不弹出
                if (treeNode.right == preNode) {    //上一次访问的节点是空节点，或是其父节点的右子节点
                    treeNode = stack.pop();
                    postIterationList.add(treeNode.val);
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        preNode = treeNode;
                    }
                } else {
                    treeNode = treeNode.right;
                    tag = false;    //避免while(!stack.isEmpty() && tag)死循环；获取treeNode = treeNode.right右子树节点们的信息，将其全部置于stack中
                }
            }
        }
    }
}
