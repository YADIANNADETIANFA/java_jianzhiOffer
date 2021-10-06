public class Singleton3 {
    private Singleton3(){}
    private static class LazyHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }
    public static Singleton3 getInstance() {
        return  LazyHolder.INSTANCE;
    }
}

/*
 * 懒汉式--静态内部类实现
 * 因为内部静态类是要在有引用了以后才会装载到内存的。
 * 所以在你第一次调用getInstance()之前，SingletonHolder是没有被装载进来的，只有在你第一次调用了getInstance()之后，
 * 里面涉及到了return SingletonHolder.instance; 产生了对SingletonHolder的引用，内部静态类的实例才会真正装载。这也就是懒加载的意思。
 * https://blog.csdn.net/jingzi123456789/article/details/80481493
 *
 * 线程安全，并且未使用锁，性能更优
 * */
