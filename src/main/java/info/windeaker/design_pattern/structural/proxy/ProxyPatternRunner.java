package info.windeaker.design_pattern.structural.proxy;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public class ProxyPatternRunner {
    public static void main(String[] args) {
        //静态代理
        HelloServiceStaticProxy staticProxy=new HelloServiceStaticProxy();
        staticProxy.sayHello("静态代理");
        //动态代理
        HelloServiceJdkDynamicProxy helloHandler=new HelloServiceJdkDynamicProxy();
        HelloService jdkDynamicProxy=(HelloService)helloHandler.bind(new HelloServiceImpl());
        jdkDynamicProxy.sayHello("jdk动态代理");
        HelloServiceImpl glibDynamicProxy=(HelloServiceImpl)new HelloServiceCglibDynamicProxy().getInstance(new HelloServiceImpl());
        glibDynamicProxy.sayHello("glib动态代理");
    }
}
