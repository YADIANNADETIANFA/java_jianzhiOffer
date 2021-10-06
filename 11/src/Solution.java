public class Solution {
    public static int getMinNum(int[] nums) throws Exception {
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

        //旋转0个数字，此时首个数字即为最小数
        if (nums[0] < nums[n - 1]) {
            return nums[0];
        }

        int left = 0;
        int right = n - 1;
        while ((right - left) > 1) {
            int mid = (left + right) / 2;

            //三个指针指向的数相同    [1,1,1,0,1]  [1,0,1,1,1]
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                return findInOrder(nums, left, right);
            }

            if (nums[left] <= nums[mid]) {
                //nums[left]小于nums[mid]，最小值在右面
                //nums[left]等于nums[mid]时，自举例，各种情况下最小值仍在右面
                left = mid;     //二分的过程中，这里对边界值并没有移除，边界值仍存在于新的数组内。因为边界值有可能是我们的最终结果。
            } else {
                //nums[left]大于nums[mid]，最小值在左面
                right = mid;
            }
        }
        return nums[right];
    }

    private static int findInOrder(int[] nums, int left, int right) {
        int minVal = nums[left];
        for (int i = left; i <= right; ++i) {
            if (nums[i] < minVal) {
                minVal = nums[i];
            }
        }
        return minVal;
    }
}

//left移动后，指针仍位于前面的递增子数组
//right移动后，指针仍位于后面的递增子数组
//最终left指针将位于前面子数组的最后一个元素，right指针将位于后面子数组的第一个元素，即left与right最终会相邻，这时取right即可