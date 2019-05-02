package example;
import java.sql.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Vector;

public class Bill {
	
	@Override
	public String toString() {
		return "Bill [billNo=" + billNo + ", custName=" + custName + ", date=" + date + ", total=" + total;
	}

	
	private int billNo;
	private String custName;
	private  Date date;
	private String desc;
	private int total;
	private Customer c;
	private Vector<pizza> pizz=new Vector<>();	
	
	public Customer getC() {
		return c;
	}


	public void setC(Customer c) {
		this.c = c;
	}
		
	public Bill(Customer c, int bno, Date d, String desc, int total)
	{
		this.c=c;
		this.date=d;
		this.billNo=bno;
		this.total=total;
		this.desc=desc;
	}
		public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


		public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

		public Bill(Customer c, Vector<pizza> pizz, String custName, String desc) throws ClassNotFoundException, SQLException {
		super();
		this.desc=desc;
		this.billNo=BillReport.getBno();
		Date d=Date.valueOf(LocalDate.now());
		this.date=d;
		this.c = c;
		this.custName=custName;
		setPizz(pizz);
	}


	public int getBillNo() {
		return billNo;
	}

	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}

	public Vector<pizza> getPizz() {
		return pizz;
	}


	public void setPizz(Vector<pizza> pizz) {
		this.pizz = pizz;
		int tot=0;
		for(pizza p:pizz)
		{
			tot=tot+p.getCostOfPizza();
		}
		this.setTotal(tot);
	}
	
	public void dispPizz()
	{
		for(pizza p:pizz)
		{
			System.out.println(p.toString());
		}
		
	}



	
	

}
