package example;

public class MexicanPizza extends pizza{
	
	
	public MexicanPizza(String type, String topping, String name,String size, int quantity, String variant) {
		super(type,topping,name,size,quantity,variant);
		costOfPizza=quantity*calculateCost();
	}
	
	@Override
	public String toString() {
		if(type!=null && costOfPizza!=0)
		{
		return "Mexican Pizza: "+type +" "+ name +" pizza with "+ topping + " and size of pizza is "+size+" and its price is "+costOfPizza ;
		}
		
		else
			
			return "";
	}

	@Override
	public int calculateCost() {
		
		int top=0;
		if(!(super.getTopping().equalsIgnoreCase("None")))
			top=30;
		if(super.getType().equalsIgnoreCase("Veg"))
		{
			if(super.getSize().equalsIgnoreCase("Regular"))
			{
				super.setCostOfPizza(200+top);
			return 200+top;
			}
			else if(super.getSize().equalsIgnoreCase("Medium"))
			{
				super.setCostOfPizza(250+top);
			return 250+top;
			}
			else
			{	
				super.setCostOfPizza(350+top);
				return 350+top;
			}	
			
		}
		else
		{
			if(super.getSize().equalsIgnoreCase("Regular"))
			{
			super.setCostOfPizza(270+top);
			return 270+top;
			}
			if(super.getSize().equalsIgnoreCase("Medium"))
			{
				super.setCostOfPizza(350+top);
				return 350+top;
			}
			else
			{
			super.setCostOfPizza(420+top);
			return 420+top;
			}
		}	
		
	}
	

}
