public class Shape {
    int x;
    int y;

    public boolean isLeftOf(Shape shape){
        return this.x < shape.x;
    }
}
