package info.windeaker.jvm.classloader;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader=ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
