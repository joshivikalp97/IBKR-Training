package example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Customer {
	
	private int custNo;
	private String custName;
	private String custAddr;
	private long custPhone;
	
	
	
	public long getCustPhone() {
		return custPhone;
	}



	public void setCustPhone(long custPhone) {
		this.custPhone = custPhone;
	}



	public Customer(String custName, String custAddr, long custPhone) throws ClassNotFoundException, SQLException {
		super();
		int cnumber=0, flag=0;
		this.custNo=CustomerReport.getCno();
		this.custName=custName;
		this.custPhone=custPhone;
		this.custAddr=custAddr;
	}
	
	public Customer(int cno, String custName, String custAddr, long custPhone) throws ClassNotFoundException, SQLException {
		super();
		this.custNo=cno;
		this.custName=custName;
		this.custPhone=custPhone;
		this.custAddr=custAddr;
	}
	
	public Customer()
	{
		
	}

	public int getCustNo() {
		return custNo;
	}
	
	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getCustAddr() {
		return custAddr;
	}
	
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	
}
