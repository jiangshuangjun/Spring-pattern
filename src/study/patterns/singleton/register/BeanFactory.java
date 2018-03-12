package study.patterns.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiangsj
 * 模拟Spring中的注册式单例
 */
public class BeanFactory {

    // 1.私有化类构造器
    private BeanFactory(){}

    // 2.定义静态私有的类对象容器
    private volatile static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();

    // 3.提供公共静态的获取该私有类对象的方法
    public static Object getBean(String className) {
        if (!ioc.containsKey(className)) {
            synchronized (BeanFactory.class) {
                if (!ioc.containsKey(className)) {
                    try {
                        Object obj = Class.forName(className).newInstance();
                        ioc.put(className,obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        return ioc.get(className);
    }
}
