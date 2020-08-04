public class Singleton2 {
    private Singleton2(){}
    private static Singleton2 singleton2 = null;
    public static Singleton2 getInstance(){
        if(singleton2 == null){
            synchronized (Singleton2.class){
                if(singleton2 == null){
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
* */
