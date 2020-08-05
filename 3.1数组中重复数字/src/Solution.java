public class Solution {

    public static int findDuplicate(int[] temp){
        //暂不考虑输入异常的问题
        for(int i=0;i<temp.length;++i){
            while(temp[i] != i){
                if(temp[i] == temp[temp[i]]){
                    return temp[i];
                }
                int miduse = temp[temp[i]];
                temp[temp[i]] = temp[i];
                temp[i] = miduse;
            }
        }
        return -1;
    }
}
