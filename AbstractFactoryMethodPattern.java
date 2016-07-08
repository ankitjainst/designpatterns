///*
//	If how to construct is more complicated than mere new 
//	“what to build” i.e. implementation class might be hidden
//*/	 
//abstract class AbstractFactory{
//	public static Base getFactory(String type)
//	{
//		switch(type)
//		{
//		case "A": return new AFactory(); 
//		case "B": return new BFactory();
//		}
//		return null;
//	}
//}
//
//class AFactory{
//	public static Base1 getFactory(String type)
//	{
//		switch(type)
//		{
//		case "A1": return new A1(); 
//		case "A2": return new A2();
//		}
//		return null;
//	}
//}
//
//class BFactory{
//	public static Base1 getFactory(String type)
//	{
//		switch(type)
//		{
//		case "B1": return new B1(); 
//		case "B2": return new B2();
//		}
//		return null;
//	}
//}
//
//interface Base1{
//	public void display();
//}
//
//class A1 implements Base1 {
//	public void display()
//	{
//		System.out.println("I am A");
//	}
//}
//
//class A2 implements Base1 {
//	public void display()
//	{
//		System.out.println("I am A");
//	}
//}
//
//class B1 implements Base1{
//	public void display()
//	{
//		System.out.println("I am B");
//	}
//}
//
//class B2 implements Base1{
//	public void display()
//	{
//		System.out.println("I am B");
//	}
//}
//
//public class AbstractFactoryMethodPattern {
//	public static void main(String[] args)
//	{
//		(Factory.getObject("A")).display();
//	}
//}
