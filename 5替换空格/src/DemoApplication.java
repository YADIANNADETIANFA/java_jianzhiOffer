public class DemoApplication {
    public static void main(String args[]){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("we are happy.");
        String res1 = Solution.getString1(stringBuilder);
        String res2 = Solution.getString2(stringBuilder);
        System.out.println(res1);
        System.out.println(res2);
    }
}
