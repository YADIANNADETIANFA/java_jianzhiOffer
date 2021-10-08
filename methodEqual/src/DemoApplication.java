import java.math.BigDecimal;

public class DemoApplication {
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1 == s2  -> " + (s1 == s2));   //true  字符串以常量形式存储，地址空间也是一样的        idea还会提示你，想要比较值，你应使用equals方法(String values are compared using '==', not 'equals()' )

        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println("s3 == s4 -> " + (s3 == s4));   //false  我们强制创建成不同的String对象，使得未以常量形式进行存储。不同对象的地址空间不一样
        System.out.println("s3 == s1 -> " + (s3 == s1));    //false 强制创建的String对象s3和常量s1，在不同的地址空间

        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("obj1 == obj2 -> " + (obj1 == obj2));    //false 不同对象的地址空间不一样
        obj2 = obj1;
        System.out.println("after obj2 = obj1, obj1 == obj2 -> " + (obj1 == obj2)); //true  指向相同的对象，因此地址空间相同

        int a = 127;
        int b = 127;
        System.out.println("a == b - > " + (a == b));   //true  基本数据类型，简单考虑，就是判断“基本类型值”是否相等
        int c = 128;
        int d = 128;
        System.out.println("c == d - > " + (c == d));   //true  同上，且基本类型不存在Integer的常量问题

        Integer A = 127;    //使用缓存常量
        Integer B = 127;    //使用缓存常量
        Integer C = new Integer(127);   //自建对象
        Integer D = new Integer(127);   //自建对象
        Integer E = Integer.valueOf(127);   //使用缓存常量
        Integer F = Integer.valueOf(127);   //使用缓存常量
        System.out.println("A == B -> " + (A == B));    //true  [-128, 127]之间，Integer缓存常量，地址相同
        System.out.println("A == C -> " + (A == C));    //false C是我们强制创建的一个对象，与Integer缓存常量地址不同  该方法已废弃
        System.out.println("A == E -> " + (A == E));    //true [-128,127]之间，Integer.valueOf返回Integer缓存常量的值，地址相同
        System.out.println("E == F -> " + (E == F));    //true  同上

        Integer G = 128;    //自建对象
        Integer H = 128;    //自建对象
        Integer I = new Integer(128);   //自建对象
        Integer J = new Integer(128);   //自建对象
        Integer K = Integer.valueOf(128);   //自建对象
        Integer L = Integer.valueOf(128);   //自建对象
        System.out.println("G == H -> " + (G == H));    //false 属Integer缓存常量之外，自动创建对象，地址不同
        System.out.println("G == K -> " + (G == K));    //false [-128,127]之外，Integer.valueOf方法会自动创建对象，地址不同
        System.out.println("K == L -> " + (K == L));    //false 同上

        System.out.println("a == A -> " + (a == A)); //true  int和Integer用 == 做比较，Integer自动拆箱，变成基本数据类型间的 == 比较，简单考虑，就是判断“基本类型值”是否相等
        System.out.println("a == C -> " + (a == C)); //true  同上
        System.out.println("c == G -> " + (c == G)); //true  同上


        double x = 300000.00000000003;
        double y = 300000.000000000003;
        double z = 300000.000000000004;
        System.out.println(" x <= 300000 -> " + (x <= 300000)); //false 精度范围内
        System.out.println(" y <= 300000 -> " + (y <= 300000)); //true  超出精度范围

        Double Y = Double.valueOf(y);
        Double Z = Double.valueOf(z);
        System.out.println("Y == Z -> " + (Y == Z));    //false 不同对象指向的地址不同
        System.out.println("Y.equals(Z) -> " + (Y.equals(Z)));  //true  比较值，但超出了精度
        System.out.println("Y.compareTo(Z) -> " + (Y.compareTo(Z)));    //0  更详细的给出比较值的结果，但超出了精度


        //对于浮点数且需要保证精度，应使用BigDecimal，虽也是约等，但是其精确地位数要高于double
        BigDecimal bigDecimal1 = new BigDecimal("0.21316413215843105431348641348413854131");    //推荐使用的构造方法，参数为str
        BigDecimal bigDecimal2 = new BigDecimal(0.21316413215843105431348641348413854131);  //不推荐使用，参数为double

        //如果参数只能是double，应使用如下处理，两者的源码其实是一样的
        BigDecimal bigDecimal3 = BigDecimal.valueOf(0.21316413215843105431348641348413854131);
        BigDecimal bigDecimal4 = new BigDecimal(Double.toString(0.21316413215843105431348641348413854131));
    }
}

/*
* equals方法是java.lang.Object类的方法，在这里，equals比较的是指向对象的地址是否相同
* 但是有一些地方会继承并重写这个方法，比如字符串类String、基本类型包装类Integer等。在这些类中，equals比较的是值
* 注意StringBuffer类中没有重新定义equals方法，其沿用Object中的老方法，仍比较地址
*
* == 判断的是指向对象的地址是否相同
*
* 基本类型的比较，编译器只提供了 == ，未提供equals方法
*
* 八大基本数据类型：Byte, short, int, long, double, float, boolean, char
* 占一个字节：byte, short, char
* 占四个字节：int, float
* 占八个字节：double, long
*
* 综上，如果仅比较值，能用equals为最优选择
*
* 可参考：https://www.cnblogs.com/weibanggang/p/9457757.html
*
* double会丢失精度的原因：   https://www.zhihu.com/question/42024389
*   0.1 = 1 除以 10       对于二级制就要算  1 除以 1010     等于0.000110011......
*
* */