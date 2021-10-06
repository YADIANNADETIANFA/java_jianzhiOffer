public class Solution {
    public static int findDuplicate(int[] array) {
        if (null == array || array.length <= 1) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    return array[i];
                }
                int temp = array[i];
                array[i] = array[array[i]];
                //此时array[i]已经发生了变化，所以要用temp
                //array[array[i]] = temp;
                array[temp] = temp;
            }
        }
        return -1;
    }
}
