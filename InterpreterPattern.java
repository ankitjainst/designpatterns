//Remember that converting from infix to postfix requires a stack of operators
//converting from postfix to a parsetree require a stack of expression
import java.util.Stack;

interface Expr{
	public int interpret();//Note it return int not Expr, it is going in DFS
}
class Number implements Expr{
	int value;
	public Number(String token)
	{
		value = Integer.parseInt(token);
	}
	public int interpret()
	{
		return value;
	}
}


class Adder implements Expr{
	Expr left;
	Expr right;
	
	public Adder(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
	public int interpret()
	{
		int result = left.interpret() + right.interpret();
		return result;
	}
}

class Multiplier implements Expr{
	Expr left;
	Expr right;
	
	public Multiplier(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
	public int interpret()
	{
		int result = left.interpret() * right.interpret();
		return result;
	}
}

//we are here converting from postfix to parse tree
class Parser{
	
	Stack<Expr> exprStack = new Stack<Expr>();
	Expr parse(String sentence)
	{
		String[]tokens = sentence.split(" ");
		for(int i=0;i<tokens.length;i++)
		{
			if(!isOperator(tokens[i]))
				exprStack.push(new Number(tokens[i]));
			else if(tokens[i].equals("+"))
			{
				Expr right = exprStack.pop();
				Expr left = exprStack.pop();
				Expr add = new Adder(left,right);
				exprStack.push(add);
			}
			else if(tokens[i].equals("*"))
			{
				Expr right = exprStack.pop();
				Expr left = exprStack.pop();
				Expr add = new Multiplier(left,right);
				exprStack.push(add);
			}
				
		}
		return exprStack.pop();
	}
	
	boolean isOperator(String s)
	{
		if (s.equals("+") || s.equals("*"))
			return true;
		return false;
	}
}

public class InterpreterPattern{
	public static void main(String[] args)
	{
		Parser p = new Parser();
		Expr e = p.parse("2 3 5 * + 2 *");
		int i = e.interpret();
		System.out.println(i);
	}
}