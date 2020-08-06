public class DemoApplication {
    public static void main(String[] args){
        int[][] array = new int[4][];
        array[0] = new int[]{1,2,8,9};
        array[1] = new int[]{2,4,9,12};
        array[2] = new int[]{4,7,10,13};
        array[3] = new int[]{6,8,11,15};
        boolean res = Solution.hasValue(array,5);
        System.out.println(res);
    }
}
