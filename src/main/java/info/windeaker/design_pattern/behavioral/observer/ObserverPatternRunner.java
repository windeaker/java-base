package info.windeaker.design_pattern.behavioral.observer;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public class ObserverPatternRunner {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
