package study.patterns.singleton.hungry;

/**
 * @author jiangsj
 * 饿汉式单例
 * 优点: (1)没有加任何的锁，执行效率较高
 *       (2)线程安全
 * 缺点: 类加载的时候就初始化，后续不一定会使用该实例，导致内存浪费
 */
public class HungrySingleton {
    // 1.私有化类构造器
    private HungrySingleton() {}

    // 2.定义静态私有的类对象
    private static HungrySingleton instance = new HungrySingleton();

    // 3.提供公共静态的获取该私有类对象的方法
    public static HungrySingleton getInstance() {
        return instance;
    }
}
