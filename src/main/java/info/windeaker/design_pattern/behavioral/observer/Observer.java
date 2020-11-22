package info.windeaker.design_pattern.behavioral.observer;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
