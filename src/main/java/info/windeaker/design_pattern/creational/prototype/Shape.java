package info.windeaker.design_pattern.creational.prototype;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/25
 */
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public Object clone(){
        Object clone=null;
        try{
            clone=super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}
