package info.windeaker.proxy.dynamic_proxy;

import info.windeaker.proxy.Hello;
import info.windeaker.proxy.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerDemo implements InvocationHandler {

    Hello hello=new HelloImpl();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(hello, args);
    }

    public static void main(String[] args) {
        Hello hello=(Hello)Proxy.newProxyInstance(InvocationHandlerDemo.class.getClassLoader(), new Class[]{Hello.class},new InvocationHandlerDemo());
        System.out.println(hello.sayHello("heheh"));
    }



}
