package info.windeaker.design_pattern.creational.prototype;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/25
 */
public class Rectangle extends Shape {
    public Rectangle(){
        type="Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() Method");
    }
}
