package info.windeaker.design_pattern.structural.proxy;

public class HelloServiceStaticProxy implements HelloService {

    HelloService hello=new HelloServiceImpl();

    @Override
    public String sayHello(String msg) {
        return hello.sayHello(msg);
    }
}
