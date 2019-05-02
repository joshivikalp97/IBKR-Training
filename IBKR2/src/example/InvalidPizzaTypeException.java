package example;
public class InvalidPizzaTypeException extends Exception {
	
	public InvalidPizzaTypeException(String s)
	{
		//super(s);
		System.out.println(s);
	}

}
