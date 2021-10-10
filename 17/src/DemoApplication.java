public class DemoApplication {
    public static void main(String[] args) {
        Solution.printNum(3);
    }
}

/*
* 考虑大数问题，使用字符数组展示，而非int、long
* 空格的ASCII码 32
* 0的ASCII码 48
* A的ASCII码 65
* a的ASCII码 97
*
* 若两个大数进行相加，也可采用本题的思路
* */