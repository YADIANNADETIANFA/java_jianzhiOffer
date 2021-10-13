public class Singleton2 {
    private Singleton2(){}
    private volatile static Singleton2 singleton2 = null;
    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}

/*
* 懒汉式--双重检查锁定
* 保证了线程安全，且不使用不会占用内存
* 但是锁会使性能偏低
*
* synchronized保证在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后才能执行该代码块
* https://www.cnblogs.com/fnlingnzb-learner/p/10335662.html
*
* 加锁是为了线程安全
* 双重判断的1号判断是为了“不用每次都加锁”；2号判断是为了“防止创建两个实例”
*
* volatile的作用：防止指令重排
* 因"singleton2 = new Singleton2()"这条语句可以分为三步：
*   1、为singleton2分配内存空间
*   2、初始化singleton2
*   3、将singleton2指向分配的内存空间
* 由于jvm可能指令重排为1-3-2，单线程下无问题，但是多线程下会导致一个线程获得一个未初始化的实例。
* 例如，线程T1执行了1和3，此时T2线程调用getInstance()后发现singleton2不为空，因此返回singleton2，但此时
* singleton2还没有被初始化，所以需要使用volatile来禁止指令重排
*
* 参考：https://www.cnblogs.com/Icarus-/p/13782623.html
* */