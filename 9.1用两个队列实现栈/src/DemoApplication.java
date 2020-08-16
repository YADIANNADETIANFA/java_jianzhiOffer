import java.util.ArrayList;

public class DemoApplication {
    public static void main(String args[]){
        Solution.myPush(0);
        Solution.myPush(1);
        Solution.myPush(2);
        Solution.myPush(3);
        Solution.myPush(4);
        ArrayList<Integer> res = new ArrayList<>();
        try{
            res.add(Solution.mayPop());
            res.add(Solution.mayPop());
            res.add(Solution.mayPop());
            res.add(Solution.mayPop());
            res.add(Solution.mayPop());
            for(var num:res){
                System.out.print(num);
                System.out.print(" ");
            }
            res.add(Solution.mayPop());
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}
