
public class NestingClass {
	class InnerClass{
		
	}
	
	static class NestedClass {
		
	}
}

class External{
	NestingClass.InnerClass c = (new NestingClass()).new InnerClass();
	
}
