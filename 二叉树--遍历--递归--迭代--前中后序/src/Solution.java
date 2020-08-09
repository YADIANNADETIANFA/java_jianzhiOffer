import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> preRecursionList;
    public ArrayList<Integer> inRecursionList;
    public ArrayList<Integer> postRecursionList;

    public ArrayList<Integer> preIterationList;
    public ArrayList<Integer> inIterationList;
    public ArrayList<Integer> postIterationList;

    Solution(TreeNode treeNode){
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

    private void preRecursion(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        preRecursionList.add(treeNode.val);
        if(treeNode.left != null){
            preRecursion(treeNode.left);
        }
        if(treeNode.right != null){
            preRecursion(treeNode.right);
        }
    }

    private void inRecursion(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        if(treeNode.left != null){
            inRecursion(treeNode.left);
        }
        inRecursionList.add(treeNode.val);
        if(treeNode.right != null){
            inRecursion(treeNode.right);
        }
    }

    private void postRecursion(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        if(treeNode.left != null){
            postRecursion(treeNode.left);
        }
        if(treeNode.right != null){
            postRecursion(treeNode.right);
        }
        postRecursionList.add(treeNode.val);
    }

    private void preIteration(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(treeNode != null || !stack.isEmpty()){
            while(treeNode != null){
                preIterationList.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    private void inIteration(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(treeNode != null || !stack.isEmpty()){
            while(treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                inIterationList.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }

    private void postIteration(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(treeNode != null || !stack.isEmpty()){
            while(treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            boolean tag = true;
            TreeNode preNode = null;    //上一次访问的节点
            while(!stack.isEmpty() && tag){
                treeNode = stack.peek();    //获取栈顶元素，但不弹出
                if(treeNode.right == preNode){  //上一次访问的节点是空节点，或是其父节点的右子节点
                    treeNode = stack.pop();
                    postIterationList.add(treeNode.val);
                    if(stack.isEmpty()){
                        return;
                    }
                    else{
                        preNode = treeNode;
                    }
                }
                else{
                    treeNode = treeNode.right;
                    tag = false;    //避免while(!stack.isEmpty() && tag)死循环；获取treeNode = treeNode.right右子树节点们的信息，将其全部置于stack中
                }
            }
        }
    }
}
