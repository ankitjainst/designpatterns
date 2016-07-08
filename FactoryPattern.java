/*
	If how to construct is more complicated than mere new 
	“what to build” i.e. implementation class might be hidden
*/	 
class Factory{
	public static Base getObject(String type)
	{
		switch(type)
		{
		case "A": return new A(); 
		case "B": return new B();
		}
		return null;
	}
}

interface Base{
	public void display();
}

class A implements Base {
	public void display()
	{
		System.out.println("I am A");
	}
}

class B implements Base{
	public void display()
	{
		System.out.println("I am B");
	}
}

public class FactoryPattern {
	public static void main(String[] args)
	{
		(Factory.getObject("A")).display();
	}
}
