package a2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Lap Wu
 * @version 10/2
 * @param <T> String  
 */
public class Notation {
	
	private static MyQueue<String> Q;
	private static MyStack<String> Stack;
	
	/**
	 * change an infix notation to a postfix notation
	 * @param infix - an expression with operator between the operand
	 * @return postfix - an expression with operator comes after operand
	 * @throws QueueOverflowException 
	 * @throws StackUnderflowException 
	 * @throws StackOverflowException 
	 * @throws InvalidNotationFormatException 
	 */
	public static String convertInfixToPostfix(String infix) throws StackUnderflowException, QueueOverflowException, StackOverflowException, InvalidNotationFormatException {
		Q= new MyQueue<String>();
		Stack=new MyStack<String>();
		String c="";
		for (int n=0;n<infix.length();n++) {
			c="";
			c+=infix.charAt(n);
			if(c.equals(" "))
				continue;
			else if(Character.isDigit(infix.charAt(n)))
				Q.enqueue(c);
			else if(c.equals("(")) {
				Stack.push(c);
				}
			else if(c.equals("/")||c.equals("+")||c.equals("-")||c.equals("*")) {
				try {
				if (Stack.top()=="/"||Stack.top()=="+"||Stack.top()=="-"||Stack.top()=="*")
					Q.enqueue(Stack.pop());}
				catch(Exception e) {
					throw new InvalidNotationFormatException();
				}
				Stack.push(c);}
			else if (c.equals(")")) {
				while(!Stack.top().equals("(")) {
					if(Stack.top()==null)
						throw new InvalidNotationFormatException();
					Q.enqueue(Stack.pop());
					}
				if (Stack.top().equals("("))
					Stack.pop();
			}
		}
		while (!Stack.isEmpty())
			Q.enqueue(Stack.pop());
		return Q.toString();
	}
	
	/**
	 * change a postfix notation to an infix notation
	 * @param postfix - an expression with operator comes after operand
	 * @return Infix - an expression with operator between the operand
	 * @throws StackOverflowException 
	 * @throws InvalidNotationFormatException 
	 * @throws StackUnderflowException 
	 */
	public static String convertPostfixToInfix(String postfix) throws StackOverflowException, InvalidNotationFormatException, StackUnderflowException{
		Stack=new MyStack<String>();
		String c="";
		String infix="";
		for (int n=0;n<postfix.length();n++) {
			c="";
			c+=postfix.charAt(n);
			if(c.equals(" "))
				continue;
			else if(Character.isDigit(postfix.charAt(n)))
				Stack.push(c);
			else if(c.equals("/")||c.equals("+")||c.equals("-")||c.equals("*")) {
				if (Stack.size()<2) 
					throw new InvalidNotationFormatException();
				infix=c+Stack.pop();
				infix=Stack.pop()+infix;
				infix="("+infix+")";
				Stack.push(infix);}
			}
		if(Stack.size()>1)
			throw new InvalidNotationFormatException();
		return infix;
	}
	
	/**
	 * calculate the postfix expression 
	 * @param postfix - an expression with operator comes after operand
	 * @return result - a double that resulted from evaluating the expression
	 * @throws StackOverflowException 
	 * @throws InvalidNotationFormatException 
	 * @throws StackUnderflowException 
	 * @throws NumberFormatException 
	 */
	public static double evaluatePostfixExpression(String postfix) throws StackOverflowException, InvalidNotationFormatException, NumberFormatException, StackUnderflowException {
		Stack=new MyStack<String>();
		String c="";
		double sol=0.0;
		double temp=0.0;
		for (int n=0;n<postfix.length();n++) {
			c="";
			c+=postfix.charAt(n);
			if(c.equals(" "))
				continue;
			else if(Character.isDigit(postfix.charAt(n))||c.equals("("))
				Stack.push(c);
			else if(c.equals("/")||c.equals("+")||c.equals("-")||c.equals("*")) {
				if (Stack.size()<2)//TODO
					throw new InvalidNotationFormatException();
				sol=0.0;
				temp=Double.parseDouble(Stack.pop());
				switch(c) {
					case "/":
						sol= Double.parseDouble(Stack.pop())/temp;
						Stack.push(String.valueOf(sol));
						break;
					case "+":
						sol= Double.parseDouble(Stack.pop())+temp;
						Stack.push(String.valueOf(sol));
						break;
					case "-":
						sol= Double.parseDouble(Stack.pop())-temp;
						Stack.push(String.valueOf(sol));
						break;
					case "*":
						sol= Double.parseDouble(Stack.pop())*temp;
						Stack.push(String.valueOf(sol));
						break;
					default:
						break;
				}
			}
		}
		if(Stack.size()>1)
			throw new InvalidNotationFormatException();
		sol=Double.parseDouble(Stack.pop());
		return sol;
	}
}
