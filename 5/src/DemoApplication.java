public class DemoApplication {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("we are happy");
        System.out.println(Solution.getString1(stringBuilder));
        System.out.println(Solution.getString2(stringBuilder));
    }
}
