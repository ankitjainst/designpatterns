/*
 * The idea behind this pattern is that there is an object ("originator") that has an internal state. There is another object (the "caretaker") that wants to perform an action over the originator, but wants to be able to undo the change.
The first thing the Caretaker does is to ask for a Memento object to the Originator (which is a representation of its internal state) and then perform the operation which will change the internal state of the Originator. If the Caretaker is not happy with the result, it can revert the changes in the internal state of the Originator using the Memento. The Originator accepts the Memento and restores its internal state.
Therefore, what you save it's the internal state of the Originator encapsulated in an object called Memento. 

Why do we store state in Memento instead of saving the object itself is because we 
want to save only those parts that are necessary to restore the state instead of the 
complete object. 
So instead of storing the wordprocessor, we are just saving the different states of 
the document only.
http://stackoverflow.com/questions/37740224/shielding-the-memento-and-aggregating-originator-in-the-caretaker-is-this-a-cor
 */
class Memento{
	String state;
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
}

class Originator{
	String state;
	
	public String getState(){return state;}
	
	public void setState(String state){this.state = state;}
	
	Memento saveStateToMemento()
	{
		Memento m = new Memento();
		m.setState(state);
		return m;
	}
	
	void restoreStateFromMemento(Memento m)
	{
		state = m.getState();
	}
}
class CareTaker{
	Memento m;
	Originator o;
	
	public CareTaker(Originator o)
	{
		this.o = o;
	}
	public void saveMemento()
	{
		m= o.saveStateToMemento();
	}
	
	public void restoreFromLastMemento()
	{
		o.restoreStateFromMemento(m);
	}
}
public class MementoPattern {
	public static void main(String[] args){
		
		Originator o1 = new Originator();
		CareTaker ct = new CareTaker(o1);
		
		o1.setState("1");
		System.out.println("initial : "+ o1.getState());
		ct.saveMemento();
		o1.setState("1A");
		System.out.println("modified : "+ o1.getState());
		ct.restoreFromLastMemento();
		System.out.println("restored : "+ o1.getState());
	}
}
