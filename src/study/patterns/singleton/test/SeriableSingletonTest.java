package study.patterns.singleton.test;

import study.patterns.singleton.seriable.SeriableSingleton;

import java.io.*;

/**
 * @author jiangsj
 * 序列化与反序列化式单例测试类
 */
public class SeriableSingletonTest {

    public static void main(String[] args) {
        SeriableSingleton s1 = SeriableSingleton.getInstance();
        SeriableSingleton s2 = null;

        // 序列化，持久化到磁盘
        try {
            FileOutputStream fos = new FileOutputStream(new File("SeriableSingleton.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 从磁盘反序列化，重新生成对象
        try {
            FileInputStream fis = new FileInputStream(new File("SeriableSingleton.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (SeriableSingleton) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("序列化时对象 s1 : " + s1);
        System.out.println("反序列化后对象 s2 : " + s2);
        System.out.println(s1 == s2);
    }

}
