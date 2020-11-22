package info.windeaker.design_pattern.behavioral.observer;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
