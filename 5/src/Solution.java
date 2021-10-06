public class Solution {
    //自带方法
    public static String getString1(StringBuilder stringBuilder) {
        return stringBuilder.toString().replace(" ", "%20");
    }

    //自写方法  原数组上进行修改
    public static String getString2(StringBuilder stringBuilder) {
        //空格个数
        int spaceNum = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == ' ') {
                ++spaceNum;
            }
        }

        //记录原stringBuilder长度
        int originalLength = stringBuilder.length();
        //修改原stringBuilder长度
        stringBuilder.setLength(originalLength + spaceNum * 2);
        int frontIndex = originalLength - 1;
        int backIndex = stringBuilder.length() - 1;
        while (backIndex > frontIndex) {
            if (stringBuilder.charAt(frontIndex) != ' ') {
                stringBuilder.setCharAt(backIndex, stringBuilder.charAt(frontIndex));
                backIndex--;
                frontIndex--;
            } else {
                stringBuilder.setCharAt(backIndex--, '0');
                stringBuilder.setCharAt(backIndex--, '2');
                stringBuilder.setCharAt(backIndex--, '%');
                frontIndex--;
            }
        }
        return stringBuilder.toString();
    }
}
