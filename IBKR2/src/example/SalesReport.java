package example;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
public class SalesReport {

	public static Sales readFromFile() throws ClassNotFoundException, IOException
	{
		Sales s=null;
		File file=new File("C:\\Users\\vikal\\Desktop\\sale");
		if(file.isFile())
		{
		FileInputStream fin=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fin);
		s=(Sales) ois.readObject();
		ois.close();
		}
		return s;
	}
	
	public static void writeToFile(Sales s) throws ClassNotFoundException, IOException
	{
		FileOutputStream fos=new FileOutputStream("C:\\Users\\vikal\\Desktop\\sale");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.close();
	}
	
	public static void updateSales(Bill b, Customer c) throws ClassNotFoundException, IOException
	{
		Sales s=SalesReport.readFromFile();
		
		if(s==null)
			s=new Sales();
		
		if(s!=null && s.getDt()!=b.getDate())
		{
			s.init();
		}
		
		Vector<pizza> p=b.getPizz();
		
		for(pizza piz: p)
		{
			if(piz.getVariant().equalsIgnoreCase("Italian"))
				s.incItalianSold(piz.getQuantity());
			else
				s.incMexicanSold(piz.getQuantity());
			
			if(piz.getType().equalsIgnoreCase("Veg"))
				s.incVegSold(piz.getQuantity());
			else
				s.incNonVegSold(piz.getQuantity());
		}
		s.incBillCount();
		s.setSalesToday(b.getTotal());
		SalesReport.writeToFile(s);
	}
}
