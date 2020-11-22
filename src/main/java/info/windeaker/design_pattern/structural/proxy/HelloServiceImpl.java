package info.windeaker.design_pattern.structural.proxy;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/1
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        String msg="hello : "+name;
        System.out.println(msg);
        return msg;
    }
}
