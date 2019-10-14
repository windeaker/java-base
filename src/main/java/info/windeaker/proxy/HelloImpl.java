package info.windeaker.proxy;

public class HelloImpl implements Hello {
    @Override
    public String sayHello(String msg) {
        return "HelloImpl:"+msg;
    }
}
