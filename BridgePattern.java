/*Basically when we have two orthogonal ways of building up the inheritance 
 * then the number of classes is a product of the concrete classes of each way
 * Shape -> RedShape & BlueShape
 * Shape -> SquareShape & CircleShape
 * All shape classes -> RedSquareShape, BlueCircleShape etc.
 * So instead of having our shape classes grow width wise as a product of two
 * Make two hierarchies and have one use a pointer of other.
 */
interface Color{
	String getColor();
}

class RedColor implements Color{
	public String getColor()
	{
		return "red";
	}
}

abstract class Shape{
	Color c;
	protected abstract String getType();
	public void display()
	{
		System.out.println("I am " + getType()+" of color "+c.getColor());
	}
	
	public Shape(Color c)
	{
		this.c = c;
	}
}

class Square extends Shape{
	protected String getType()
	{
		return "Square";
	}
	
	public Square(Color c)
	{
		super(c);
	}
}

public class BridgePattern {
	public static void main(String[] args)
	{
		Color c = new RedColor();
		//Note here a pointer of the other hierarchial division is passed at constructor
		Shape s = new Square(c);
		s.display();
	}
}
