package figureCalculator;

public class Rectangle extends Figure{
    String name = "사각형";
    int width;
    int height;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double setRadius(int r) {
        return 0;
    }
}

