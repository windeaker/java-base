package info.windeaker.design_pattern.structural.decorator;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/30
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
public ShapeDecorator(Shape decoratedShape){
    this.decoratedShape=decoratedShape;
}

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
