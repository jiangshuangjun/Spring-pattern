package study.patterns.singleton.lazy;

/**
 * @author jiangsj
 * 懒汉式1单例
 * 优点: 由于懒汉式延时加载特性，使用该实例时才实例化，节省了内存资源
 * 缺点: (1)该种实现方式存在线程不安全问题
 *       (2)反序列化，反射与克隆可破坏单例
 */
public class LazySingleton1 {
    // 1.私有化类构造器
    private LazySingleton1() {}

    // 2.定义静态私有的类对象
    private static LazySingleton1 instance = null;

    // 3.提供公共静态的获取该私有类对象的方法
    public static LazySingleton1 getInstance() {
        if (instance == null) {
            instance = new LazySingleton1();
        }

        return instance;
    }
}