package info.windeaker.design_pattern.behavioral.observer;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
