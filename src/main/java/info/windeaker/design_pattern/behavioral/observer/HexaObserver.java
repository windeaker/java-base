package info.windeaker.design_pattern.behavioral.observer;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public class HexaObserver extends Observer {
    public HexaObserver(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
