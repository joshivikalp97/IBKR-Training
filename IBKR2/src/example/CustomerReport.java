package example;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class CustomerReport {
	
	public static int getCno() throws ClassNotFoundException, SQLException
	{
		Connection con=Dbc.getConnection();
		Statement s=con.createStatement();
		PreparedStatement ps2=null;
		ResultSet rs=s.executeQuery("Select max(cno) from cust");
		while(rs.next())
		{
			return (rs.getInt(1)+1);
		}
		
		return 1;
	}
	
	public static void SaveCust(Customer c) throws ClassNotFoundException, SQLException
	{
		Connection con=Dbc.getConnection();
		Statement s=con.createStatement();
		PreparedStatement ps2=con.prepareStatement("Insert into cust values(?,?,?,?)");
		ps2.setInt(1, c.getCustNo());
		ps2.setString(2,c.getCustName());
		ps2.setString(3, c.getCustAddr());
		ps2.setLong(4, c.getCustPhone());
		ps2.execute();
	}
	
	public static Customer RetrieveByCno(int custno) throws ClassNotFoundException, SQLException
	{
		
		Connection con=Dbc.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from cust where cno=? ");
		Customer c=null;
		ps.setInt(1, custno);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			c=new Customer(custno, rs.getString(2),rs.getString(3),rs.getLong(4));
		}
		/*ps=con.prepareStatement("delete from cust");
		ps.executeQuery();
		ps=con.prepareStatement("delete from bill");
		ps.executeQuery();
		*/
		return c;
	}
	
	public static Customer RetrieveByCphone(long cphone) throws ClassNotFoundException, SQLException
	{
		
		Connection con=Dbc.getConnection();
		Customer c=null;
		PreparedStatement ps=con.prepareStatement("Select * from cust where phone=? ");
		ps.setLong(1, cphone);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			c=new Customer(rs.getInt(1), rs.getString(2),rs.getString(3), cphone);
		}
		return c;
	}
	
	public static void RetrieveReport() throws ClassNotFoundException, SQLException
	{
		Vector<Bill> v=new Vector<Bill>();
		Connection con=Dbc.getConnection();
		PreparedStatement ps=con.prepareStatement("Select b.bno, b.cno, b.cname, c.phone, b.dt, b.des, b.total from bill b, cust c where b.cno=c.cno");
		ResultSet rs=ps.executeQuery();
		System.out.println("\n\n*******REPORT*******");
		while(rs.next())
		{
		System.out.println("\nBill number "+"\tCustomer no. "+"\tCustomer Name "+"\tAddress "+"\tBill Date "+"\tDescription "+"\t   Total");
		System.out.println(rs.getInt(1)+"\t\t "+rs.getInt(2)+"\t\t "+rs.getString(3)+"\t\t "+rs.getString(4)+"\t    "+rs.getString(5)+"\t     "+rs.getString(6)+"     "+rs.getInt(7));
		}
	}
	

}
