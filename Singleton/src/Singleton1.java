public class Singleton1 {
    private Singleton1(){}
    private static final Singleton1 single = new Singleton1();
    public static Singleton1 getInstance() {
        return single;
    }
}

/*
* 饿汉式
* 构造函数私有化
* 私有静态变量指向自己的实例
* 公有静态方法返回自己实例
* 天生线程安全
* */
