package info.windeaker.proxy.static_proxy;

import info.windeaker.proxy.Hello;
import info.windeaker.proxy.HelloImpl;

public class StaticProxiedHello implements Hello {

    Hello hello=new HelloImpl();

    @Override
    public String sayHello(String msg) {
        return hello.sayHello(msg);
    }
}
