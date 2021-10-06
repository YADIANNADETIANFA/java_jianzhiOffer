public class DemoApplication {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,4,0,1};
        try{
            int res = Solution.getMinNum(nums);
            System.out.print(res);
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
