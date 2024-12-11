package figureCalculator;

public class Circle extends Figure{

    String name = "원";
    double r;

    @Override
    public double area() {
        double d = this.r * this.r * Math.PI;
        double result = (Math.floor(d*100)/100.0);
        return result;
    }


    @Override
    public double setRadius(int r) {
        return this.r = r;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }
}
