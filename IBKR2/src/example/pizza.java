package example;

public abstract class pizza {
	
	protected String type;
	protected String topping;
	protected String name;
	protected int costOfPizza;
	protected String size;
	protected int quantity;
	protected String variant;
	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public pizza()
	{
		type="veg";
		topping="onions";
		name="Italians";
		
	}

	public pizza(String type, String topping, String name,String size,int quantity, String variant) {
		super();
		try
		{
		if(type.equalsIgnoreCase("veg") || type.equalsIgnoreCase("NonVeg"))
		{
		
		try
		{
			if(size.equalsIgnoreCase("Regular") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("Large"))
			{
		this.type = type;
		this.topping = topping;
		this.name = name;
		this.quantity=quantity;
		this.variant=variant;
		//this.costOfPizza=costOfPizza;
		this.size=size;
			}
			
			else
				throw new InvalidPizzaSizeException("invalid size enter regular, large or medium"); 
		}
		
		   catch(InvalidPizzaSizeException e)
		{
			System.out.println(e);   
		}
		}
		
		else
		{
			throw new InvalidPizzaTypeException(" invalid_type ");
		}	
	   }
		
		catch(InvalidPizzaTypeException e)
		{
			System.out.println(e);
		}
		
		finally {
			
			this.type = type;
			this.topping = topping;
			this.name = name;
			this.quantity=quantity;
			this.variant=variant;
			//this.costOfPizza=costOfPizza;
			this.size=size;
			
			
			try
			{
			
			if(size.equalsIgnoreCase("Regular") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("Large"))
			{
			
			}
			
			else
				throw new InvalidPizzaSizeException(" invalid_size "); 
			}
				
			   catch(InvalidPizzaSizeException e)
				{
					System.out.println(e);   
				}
			
			
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return type + name +" pizza with "+ topping + " and size of pizza is "+size+" and its price is "+costOfPizza ;
	}
	
	
	public int getCostOfPizza() {
		return costOfPizza;
	}

	public void setCostOfPizza(int costOfPizza) {
		this.costOfPizza = costOfPizza;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	abstract public int calculateCost();
	
	

}
