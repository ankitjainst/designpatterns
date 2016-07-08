import java.util.ArrayList;
class Association{
	class Square{
		void paint(RedColor c)
		{
			System.out.println("Painting square in the color "+c.myColor());
		}
	}
	
	class RedColor{
		String myColor()
		{
			return "red";
		}
	}
}
//Association when a method in class takes or returns another class object
//Aggregation when the class stores in a field a reference through some set function
//Composition when objects of other class ARE CREATED and stored in a class
//Composition is when "built out of"
class Aggregation {
	//An application for some people in a society
	//A person can exist out of Company.
	class Person{
		Person(){
		}
	}
	
	class Company{
		ArrayList<Person> employees;
		Company(){
			employees = new ArrayList<Person>();
		}
		
		void addEmployee(Person p){
			employees.add(p);
		}
	}
}

class Composition{
	//An application made for Company to maintain Employee Records
	//An employee cannot exist outside a Company
	class Employee{
		Company c;
		private Employee(Company c) {
			this.c = c;
		}
	}
	
	class Company{
		ArrayList<Employee> employees;
		int lastEmployeeNumber;
		Company() {
			employees = new ArrayList<Employee>();
			lastEmployeeNumber =0;
		}
		
		//Note we are not allowing outside world to create Employee objects
		int addEmployee(String name)
		{
			employees.add(new Employee(this));
			return ++lastEmployeeNumber;
		}
	}
}