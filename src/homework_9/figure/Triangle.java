package homework_9.figure;

public class Triangle extends Figure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double calculationPerimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    public double calculationArea() {
        double s = calculationPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return  "Triangle[" + "a=" + a + ", b=" + b + ", c=" + c + ']';
    }
}
