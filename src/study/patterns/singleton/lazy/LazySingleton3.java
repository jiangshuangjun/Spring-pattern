package study.patterns.singleton.lazy;

/**
 * @author jiangsj
 * 懒汉式3——双重锁检查单例
 * 优点: (1)由于懒汉式延时加载特性，使用该实例时才实例化，节省了内存资源
 *       (2)线程安全
 * 缺点: (1)如果不加volatile关键词防止指令重排，双重锁检查单例可能会出现不完整实例
 *       (2)反序列化，反射与克隆可破坏单例
 */
public class LazySingleton3 {
    // 1.私有化类构造器
    private LazySingleton3() {}

    // 2.定义静态私有的类对象，为了防止出现不完整实例，加了防止指令重排的volatile关键字
    private static volatile LazySingleton3 instance = null;

    // 3.提供公共静态的获取该私有类对象的方法，为了线程安全，做了双重锁检查机制
    public static LazySingleton3 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton3.class) {
                if (instance == null) {
                    instance = new LazySingleton3();
                }
            }
        }

        return instance;
    }
}
