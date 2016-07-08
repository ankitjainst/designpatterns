interface State{
	public void doAction(Context c);
}
class State1 implements State{
	public void doAction(Context c)
	{
		System.out.println("Action of state 1");
		//Note we are making state objects again everytime
		c.setState(new State2());
	}
}
class State2 implements State{
	public void doAction(Context c)
	{
		System.out.println("Action of state 2");
		c.setState(new State1());
	}
}

/*This should be public and exposed outside. 
 * I would name it the Operator of the machine*/
class Context{
	State currState;
	Context()
	{
		currState = new State1();
	}
	public void act()
	{
		currState.doAction(this);
	}

	public void setState(State state) 
	{
		currState = state;
	}

	public State getState() 
	{
		return currState;
	}
}

public class StatePattern {
	public static void main(String[] args)
	{
		Context machineOperator = new Context();
		machineOperator.act();
		machineOperator.act();
		machineOperator.act();
	}
}