package study.patterns.singleton.seriable;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author jiangsj
 * 序列化与反序列化式单例
 */
public class SeriableSingleton implements Serializable {
    // 1.私有化类构造器
    private SeriableSingleton() {}

    // 2.定义静态私有的类对象
    private static final SeriableSingleton INSTANCE = new SeriableSingleton();

    // 3.提供公共静态的获取该私有类对象的方法
    public static SeriableSingleton getInstance() {
        return INSTANCE;
    }

    // 4.重写readResolve()方法，保证反序列化生成对象时获得的是同一个对象
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
