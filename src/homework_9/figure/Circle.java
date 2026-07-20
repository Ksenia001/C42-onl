package homework_9.figure;

class Circle extends Figure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculationPerimeter() {
        return 2 * Math.PI * this.radius;
    }
    @Override
    public double calculationArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return "Circle[" + "radius=" + radius + ']';
    }
}
