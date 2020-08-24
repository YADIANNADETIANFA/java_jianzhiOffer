import java.util.ArrayList;

public class DemoApplication {
    public static void main(String args[]){
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        matrix.add(0,new ArrayList<Character>());   //用add，不用set，set会报越界异常
        matrix.add(1,new ArrayList<Character>());
        matrix.add(2,new ArrayList<Character>());
        matrix.get(0).add('a');     //用add，不用set，set会报越界异常
        matrix.get(0).add('b');
        matrix.get(0).add('t');
        matrix.get(0).add('g');
        matrix.get(1).add('c');
        matrix.get(1).add('f');
        matrix.get(1).add('c');
        matrix.get(1).add('s');
        matrix.get(2).add('j');
        matrix.get(2).add('d');
        matrix.get(2).add('e');
        matrix.get(2).add('h');

        boolean res1 = Solution.hasPath(matrix,3,4,"bfce");
        boolean res2 = Solution.hasPath(matrix,3,4,"abfb");
        System.out.println(res1);
        System.out.println(res2);
    }
}
