/*
	Why inheritance : Certain functionality common accross types is moved to base
	Why abstract classes : Certain functionality which is common is dependent on types i.e. abstract function
	Why abstract function : The functionality that is specific to type
	
	So an abstract class will do what is common across its extending classes,
*/	 
abstract class FactoryM{
	
	public BaseM create(String type)
	{
		//do some common functionality such as DB instantiation
		//bla bla bla
		BaseM bm = doSpecificOperation(type);
		//bla bla on bm
		return bm;
	}
	protected abstract BaseM doSpecificOperation(String type); 
}

class FactoryA extends FactoryM{
	protected BaseM doSpecificOperation(String type)
	{
		return new AM();
	}
}

class FactoryB extends FactoryM{
	protected BaseM doSpecificOperation(String type)
	{
		return new BM();
	}
}

interface BaseM{
	public void display();
}

class AM implements BaseM {
	public void display()
	{
		System.out.println("I am AM");
	}
}

class BM implements BaseM {
	public void display()
	{
		System.out.println("I am BM");
	}
}

public class FactoryMethodPattern {
	public static void main(String[] args)
	{
		(new FactoryA()).create("A").display();
	}
}