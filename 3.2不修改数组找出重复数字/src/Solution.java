public class Solution {
    public static int getDuplication(int[] temp) {
        //暂不考虑异常输入
        int left = 1;
        int right = temp.length - 1;
        while(left <= right){
            int mid = (right - left)/2 + left;//这个取mid的方法
            int count = getCount(temp,left,mid);
            if(left == right){
                if(count > 1){
                    return left;
                }
                else{
                    break;
                }
            }
            if(count > (mid - left + 1)){
                //左边必重复
                right = mid;
            }else{
                //右边必重复
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int getCount(int[] temp, int start, int mid){
        int count = 0;
        for(var val : temp){
            if(val >= start && val <= mid){
                ++count;
            }
        }
        return count;
    }
}

/*
*   背下该二分框架，二分最难的就是应对边界值
*
* 假设1~7，则共8个数
* 若左右都想不重复
*         1~4          5~7
* 则个数  <=4           <=3   明显不可能
* 所以若有重复数字，则必至少要有一边超范围，
* 而且超范围必重复（你举不出任何反例来）
* 所以，若左不超范围则右必超范围此时重复在右；若右不超范围则左必超范围此时重复在左
* */
