剑指Offer_java实现

能够手动绘图自举各种例子，是很好地解题手段

二分法：
        3.2、11  有涉及二分的内容
        int left = 1;
        int right = array.length - 1;
        int mid = (right - left) / 2 + left;    //这个取mid的方法 等价于 int mid = (left + right) / 2
        二分的过程中，如果边界值绝对不会是最终的结果，则新数组中不应存在上一次的边界值；    3.2
            反之，如果边界值可能会是最终的结果，则新数组中应保留上一次的边界值。  11




