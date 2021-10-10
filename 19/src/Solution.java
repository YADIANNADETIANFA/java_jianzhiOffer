public class Solution {
    public static boolean match(String str, String pattern) {   //str是纯字符串，不含正则字符
        if (str == null || pattern == null) {
            return false;
        }
        if ("".equals(str)) {
            if ("".equals(pattern)) {
                return true;
            }
            if (pattern.length() == 2 && pattern.charAt(1) == '*') {
                return true;
            } else {
                return false;
            }
        }
        return matchCore(str, pattern, 0, 0);
    }

    public static boolean matchCore(String str, String pattern, int index1, int index2) {
        if (index1 >= str.length() && index2 >= pattern.length()) {
            return true;
        }
        if (index1 >= str.length() && index2 == pattern.length() - 2 && pattern.charAt(index2 + 1) == '*') {    //a     ab*
            return true;
        }
        if (index1 >= str.length() || index2 >= pattern.length()) {
            return false;
        }
        if (index2 < (pattern.length() - 1) && pattern.charAt(index2 + 1) == '*') {
            if (str.charAt(index1) == pattern.charAt(index2) || pattern.charAt(index2) == '.') {
                return matchCore(str,pattern, index1 + 1, index2 + 2)
                        || matchCore(str,pattern, index1 + 1, index2)
                        || matchCore(str,pattern, index1, index2 + 2);
            } else {
                return matchCore(str, pattern, index1, index2 + 2);
            }
        }

        if (pattern.charAt(index2) == '.') {
            return matchCore(str, pattern, index1 + 1, index2 + 1);
        }

        if (pattern.charAt(index2) == str.charAt(index1)) {
            return matchCore(str, pattern, index1 + 1, index2 + 1);
        } else {
            return false;
        }
    }
}

/*
* 第一感觉，这题要递归
* */
