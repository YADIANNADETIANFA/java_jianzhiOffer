public class DemoApplication {
    public static void main(String args[]){
        var arrayA1 = new int[10];
        arrayA1[0]=1;
        arrayA1[1]=3;
        arrayA1[2]=5;
        arrayA1[3]=7;
        arrayA1[4]=9;
        var arrayA2 = new int[]{4,6,8};
        Solution.getMergeArray(arrayA1,5,arrayA2,3);
    }
}
