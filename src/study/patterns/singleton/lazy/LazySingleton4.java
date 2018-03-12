package study.patterns.singleton.lazy;

/**
 * @author jiangsj
 * 懒汉式4——静态内部类单例
 * 优点: (1)由于懒汉式延时加载特性，使用该实例时才实例化，节省了内存资源
 *       (2)在外部类被调用的时候内部类才会被加载，内部类要在方法调用之前初始化，巧妙地避免了线程安全问题
 *       (3)兼顾了synchronized的性能问题
 * 缺点: 反序列化，反射与克隆可破坏单例
 */
public class LazySingleton4 {
    private boolean initialized = false;

    // 1.私有化类构造器
    private LazySingleton4() {
        synchronized (LazySingleton4.class) {
            if (initialized == false) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    // 2.定义静态私有的类对象
    private static class LazyHolder {
        private static final LazySingleton4 INSTANCE = new LazySingleton4();
    }

    // 3.提供公共静态的获取该私有类对象的方法
    public static final LazySingleton4 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
