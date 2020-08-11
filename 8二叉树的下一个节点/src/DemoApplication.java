public class DemoApplication {
    public static void main(String args[]){
        TreeNode tempA = new TreeNode('a');
        TreeNode tempB = new TreeNode('b');
        TreeNode tempC = new TreeNode('c');
        TreeNode tempD = new TreeNode('d');
        TreeNode tempE = new TreeNode('e');
        TreeNode tempF = new TreeNode('f');
        TreeNode tempG = new TreeNode('g');
        TreeNode tempH = new TreeNode('h');
        TreeNode tempI = new TreeNode('i');
        tempA.left = tempB;
        tempA.right = tempC;
        tempB.left = tempD;
        tempB.right = tempE;
        tempC.left = tempF;
        tempC.right = tempG;
        tempE.left = tempH;
        tempE.right = tempI;
        tempH.parent = tempE;
        tempI.parent = tempE;
        tempG.parent = tempC;
        tempF.parent = tempC;
        tempE.parent = tempB;
        tempD.parent = tempB;
        tempC.parent = tempA;
        tempB.parent = tempA;

        try{
            TreeNode resA = Solution.getNextNode(tempA,tempA);
            TreeNode resB = Solution.getNextNode(tempA,tempB);
            TreeNode resC = Solution.getNextNode(tempA,tempC);
            TreeNode resD = Solution.getNextNode(tempA,tempD);
            TreeNode resE = Solution.getNextNode(tempA,tempE);
            TreeNode resI = Solution.getNextNode(tempA,tempI);
            TreeNode resG = Solution.getNextNode(tempA,tempG);
            int i = 0;
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}
