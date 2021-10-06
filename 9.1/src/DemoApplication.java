import java.util.ArrayList;

public class DemoApplication {
    public static void main(String[] args) {
        try{
            Solution.pushToTail(0);
            Solution.pushToTail(1);
            Solution.pushToTail(2);
            Solution.pushToTail(3);
            Solution.pushToTail(4);
            ArrayList<Integer> res = new ArrayList<>();
            res.add(Solution.popFromTail());
            res.add(Solution.popFromTail());
            res.add(Solution.popFromTail());
            res.add(Solution.popFromTail());
            res.add(Solution.popFromTail());
            for(var num:res){
                System.out.print(num);
                System.out.print(" ");
            }
            res.add(Solution.popFromTail());
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}
