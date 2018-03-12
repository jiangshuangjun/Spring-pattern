package study.patterns.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiangsj
 * 注册登记式——map容器单例
 */
public class RegisterSingletonMap {

    // 1.私有化类构造器
    private RegisterSingletonMap() {}

    // 2.定义静态私有的类对象容器
    private static Map<String, RegisterSingletonMap> map = new ConcurrentHashMap<String, RegisterSingletonMap>();

    // 3.提供公共静态的获取该私有类对象的方法
    public static RegisterSingletonMap getInstance(String name) {
        String className = RegisterSingletonMap.class.getName();

        if (!className.equals(name)) {
            name = className;
        }

        // double check
        if (!map.containsKey(name)) {
            synchronized (RegisterSingletonMap.class) {
                if (!map.containsKey(name)) {
                    map.put(name, new RegisterSingletonMap());
                }
            }
        }

        return map.get(name);
    }
}
