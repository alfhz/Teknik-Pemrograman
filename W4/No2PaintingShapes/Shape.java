package No2PaintingShapes;

abstract public class Shape {
    private String shapeName;

    abstract public double area();

    public String toString() {
        return shapeName;
    }
    
    public Shape(String name) {
        shapeName = name;
    }
}
