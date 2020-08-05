public class DemoApplication {
    public static void main(String[] args){
        var temp = new int[]{2,3,1,0,2,5,3};
        int res = Solution.findDuplicate(temp);
        System.out.println(res);
    }
}
