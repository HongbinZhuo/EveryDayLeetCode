package Biuld_ModelPattern_5kind.Singleton;

/*     较为标准的单例*/
public class Singleton01 {

    /* 私有构造方法，防止被实例化 */
    private Singleton01() {
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static Singleton01 instance = new Singleton01();
    }

    /* 获取实例 */
    public static Singleton01 getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}
