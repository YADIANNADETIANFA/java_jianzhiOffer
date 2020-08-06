public class Solution {
    public static void getMergeArray(int[] arrayA1, int arrayA1Size, int[] arrayA2, int arrayA2Size){
        int totalIndex = arrayA1Size + arrayA2Size - 1;
        int indexA1 = arrayA1Size - 1;
        int indexA2 = arrayA2Size - 1;
        while(indexA2 >= 0){
            if(arrayA1[indexA1]>=arrayA2[indexA2]){
                arrayA1[totalIndex] = arrayA1[indexA1];
                totalIndex--;
                indexA1--;
            }else{
                arrayA1[totalIndex] = arrayA2[indexA2];
                totalIndex--;
                indexA2--;
            }
        }
    }
}

//假定A1后面有足够的空间容纳A1+A2
//arrayA1.length是数组初始化时的总长度，无利用价值
//总之就是，从后往前