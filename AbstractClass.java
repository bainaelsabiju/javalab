public class AbstractClass{
	public static void main(String[]args) {
		Rectangle r = new Rectangle();
		Triangle t = new Triangle();
		Hexagon h = new Hexagon();
		r.numberofsides();
		t.numberofsides();
		h.numberofsides();
	}
	}
abstract class Shape{
	abstract public void numberofsides();
}
				
			
		
		class Rectangle extends Shape{
			public void numberofsides() {
		System.out.println("the number of sides is 4");
		}
	}
class Triangle extends Shape{
	public void numberofsides() {
		System.out.println("the number of sides is 3");
	}
}
class Hexagon extends Shape{
	public void numberofsides() {
		System.out.println("the number of sides is 6");
		
	}
}
