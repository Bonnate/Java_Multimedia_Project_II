import java.lang.Math;

public class JavaTest {
	public static void main(String[] args) {
		Shape shape[] = new Shape[3];
		shape[0] = new Square(4);
		shape[1] = new Circle(2);
		shape[2] = new Square(5);
		for (Shape s : shape) {
			printShape(s);
		}
	}

	public static void printShape(Shape shape) {
		System.out.print("Area: " + shape.getArea());
		System.out.println(" , Perimeter: " + shape.getPerimeter());
	}
}

abstract class Shape {
	protected abstract double getArea();

	protected abstract double getPerimeter();
}

class Square extends Shape {
	private double side;

	public Square(int side) {
		this.side = side;
	}

	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() { // 둘레
		return 4 * side;
	}
}

class Circle extends Shape {
	private double rad;

	public Circle(int rad) {
		this.rad = rad;
	}

	@Override
	public double getArea() {
		return Math.floor(Math.PI * rad * rad * 100) / 100;
	}

	@Override
	public double getPerimeter() {
		return Math.floor(Math.PI * 2 * rad * 100) / 100;
	}
}
