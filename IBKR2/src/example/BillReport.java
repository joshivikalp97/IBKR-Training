package example;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Vector;

public class BillReport {
	
	public static void SaveBill(Bill b, Customer c) throws ClassNotFoundException, SQLException, IOException
	{
		
		Vector<pizza> p=b.getPizz();
		SalesReport.updateSales(b,c);
		Connection con=Dbc.getConnection();
		PreparedStatement ps=con.prepareStatement("Insert into bill values(?,?,?,?,?,?)");
		ps.setInt(1, b.getBillNo());
		ps.setInt(2, b.getC().getCustNo());
		ps.setString(3, b.getCustName());
		ps.setDate(4, b.getDate());
		ps.setString(5, b.getDesc());
		ps.setInt(6, b.getTotal());
		ps.executeQuery();

		System.out.println("Bill entered into the database successfully! ");
	}
	
	
	public static int getBno() throws ClassNotFoundException, SQLException
	{
		Connection con=Dbc.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("Select max(bno) from bill");
		while(rs.next())
		return (rs.getInt(1)+1);
		return 1;
	}
	
	public static Bill RetrieveBill(int billno) throws ClassNotFoundException, SQLException
	{
		Bill b=null;
		Connection con=Dbc.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from bill where bno=? ");
		ps.setInt(1, billno);
		ResultSet rs=ps.executeQuery();
		Customer c=null;
		while(rs.next())
		{
			ps=con.prepareStatement("Select * from cust where cno=? ");
			ps.setInt(1, rs.getInt(2));
			ResultSet rs2=ps.executeQuery();
			while(rs2.next())
			{
				c=new Customer(rs2.getInt(1),rs2.getString(2),rs2.getString(3),rs2.getLong(4));
			}
			b=new Bill(c,rs.getInt(1),rs.getDate(4), rs.getString(5), rs.getInt(6));
			b.setCustName(b.getC().getCustName());
		}
		return b;
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
