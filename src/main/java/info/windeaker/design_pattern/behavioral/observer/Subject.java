package info.windeaker.design_pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/7
 */
public class Subject {
    List<Observer> observers=new ArrayList<>();
    private int state;
    public int getState(){
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
