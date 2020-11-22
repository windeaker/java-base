package info.windeaker.base_feature.generics;

public class NotGenericsClass {
    /**
     * 静态泛型方法
     * @param t
     * @param <T>
     */
    public static <T> void staticFunction(T t) {

    }

    /**
     * 非泛型类使用泛型方法
     * @param t
     * @param <T>
     */
    public <T> void notStaticFunction(T t) {

    }
}
