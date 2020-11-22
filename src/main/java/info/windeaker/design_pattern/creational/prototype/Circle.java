package info.windeaker.design_pattern.creational.prototype;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/25
 */
public class Circle extends Shape {
    public  Circle(){
        type="Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() Method");
    }
}
