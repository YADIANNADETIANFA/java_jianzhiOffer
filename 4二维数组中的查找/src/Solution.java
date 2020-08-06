public class Solution {
    public static boolean hasValue(int[][] array,int searchNum){
        int column = array[0].length - 1;
        int row = 0;
        while(column >= 0 && (row <= array.length - 1)){
            if(array[row][column] == searchNum){
                return true;
            }
            if(array[row][column] > searchNum){
                --column;
            }else{
                ++row;
            }
        }
        return false;
    }
}

/*
* 选取最新二维数组的右上角
* if(array[][]>searchNum)去掉该列
* if(array[][]<searchNum)去掉该行
* 然后获取最新二维数组，回到第一步
* */
