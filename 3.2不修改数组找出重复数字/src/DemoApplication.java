public class DemoApplication {
    public static void main(String[] args){
        var temp0 = new int[]{2,3,5,4,3,2,6,7};
        var temp1 = new int[]{1,2,3,4,5,6,7,8,8};
        var temp2 = new int[]{1,1,2};
        var temp3 = new int[]{1,2,2};
        var temp4 = new int[]{1,1,2,3};
        var temp5 = new int[]{1,2,2,3};
        var temp6 = new int[]{1,2,3,3};
        int res0 = Solution.getDuplication(temp0);
        int res1 = Solution.getDuplication(temp1);
        int res2 = Solution.getDuplication(temp2);
        int res3 = Solution.getDuplication(temp3);
        int res4 = Solution.getDuplication(temp4);
        int res5 = Solution.getDuplication(temp5);
        int res6 = Solution.getDuplication(temp6);
        System.out.println(res0);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
    }
}
