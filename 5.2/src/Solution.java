public class Solution {
    public static void mergeArray(int[] array1, int[] array2, int array1Size, int array2Size) {
        //不可用数组长度,int[] array1 = new int[10];获取的数组长度是10 ！ 未初始化值默认为0
        //必须手动传入已初始化的数组长度！
        //int backIndex = array1.length + array2.length - 1;
        //int frontIndex = array1.length - 1;
        //int array2Index = array2.length - 1;
        int backIndex = array1Size + array2Size - 1;
        int frontIndex = array1Size - 1;
        int array2Index = array2Size - 1;
        while (array2Index >= 0) {
            if (array1[frontIndex] > array2[array2Index]) {
                array1[backIndex] = array1[frontIndex];
                backIndex--;
                frontIndex--;
            } else {
                array1[backIndex] = array2[array2Index];
                backIndex--;
                array2Index--;
            }
        }
    }
}

//假定A1后面有足够的空间容纳A1+A2
//arrayA1.length是数组初始化时的总长度，无利用价值
//总之就是，从后往前
