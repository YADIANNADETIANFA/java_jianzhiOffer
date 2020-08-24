
public class Solution {
    public static int getMinNum(int[] nums) throws Exception{
        if(null == nums){
            throw new Exception("Invaild Input");
        }
        int n = nums.length;
        if(n == 0){
            throw new Exception("Invalid Input");
        }
        if(n == 1){
            return nums[0];
        }

        //情况一，旋转0个数字，此时首个数字即为最小数
        if(nums[0]<nums[n-1]){
            return nums[0];
        }
        //正常情况
        int left = 0;
        int right = n-1;
        while(right-left>1){
            int mid = (left + right)/2; //这里并不是标准的二分法，只是类似二分
            if(nums[left]==nums[mid] && nums[mid]==nums[right]){    //情况二，三个指针指向的数相同    [1,1,1,0,1]  [1,0,1,1,1]
                return findInOrder(nums);
            }
            if(nums[left]<=nums[mid]){
                left=mid;
            }else{
                right=mid;
            }
        }
        return nums[right];
    }

    private static int findInOrder(int[] nums){
        int myMin=nums[0];
        for(var num:nums){
            if(num<myMin){
                myMin=num;
            }
        }
        return myMin;
    }
}

//left移动后，指针仍位于前面的递增子数组
//right移动后，指针仍位于后面的递增子数组
//最终left指针将位于前面子数组的最后一个元素，right指针将位于后面子数组的第一个元素，即left与right最终会相邻，这时取right即可
