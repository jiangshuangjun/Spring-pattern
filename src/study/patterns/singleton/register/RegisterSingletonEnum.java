package study.patterns.singleton.register;

/**
 * @author jiangsj
 * 注册登记式——枚举单例
 */
public class RegisterSingletonEnum {
    // 1.私有化类构造器
    private RegisterSingletonEnum() {}

    // 2.提供公共静态的获取该私有类对象的方法
    public static RegisterSingletonEnum getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    // 3.定义静态私有的枚举对象，利用枚举特性获得类的单实例
    private static enum Singleton {
        INSTANCE;

        private RegisterSingletonEnum singleton;

        // JVM保证此方法只调用一次
        private Singleton() {
            singleton = new RegisterSingletonEnum();
        }

        public RegisterSingletonEnum getInstance() {
            return singleton;
        }
    }
}
