public class DemoApplication {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        array1[0] = 1;
        array1[1] = 3;
        array1[2] = 5;
        array1[3] = 7;
        array1[4] = 9;

        int[] array2 = new int[]{4,6,8};
        Solution.mergeArray(array1, array2, 5, 3);
        for (int i : array1) {
            System.out.println(i);
        }
    }
}
