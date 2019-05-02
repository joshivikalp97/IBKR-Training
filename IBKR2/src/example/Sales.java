package example;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Sales implements Serializable {


	Date dt;
	int BillCount;
	int VegSold;
	int NonVegSold;
	int ItalianSold;
	int MexicanSold;
	int SalesToday;
	
	public int getBillCount() {
		return BillCount;
	}

	public void incBillCount() {
		BillCount++;
	}


	
	
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	public int getVegSold() {
		return VegSold;
	}
	public void incVegSold(int quantity) {
		VegSold=VegSold+quantity;
	}
	public int getNonVegSold() {
		return NonVegSold;
	}
	public void incNonVegSold(int quantity) {
		NonVegSold=NonVegSold+quantity;
	}
	public int getItalianSold() {
		return ItalianSold;
	}
	public void incItalianSold(int quantity) {
		ItalianSold=ItalianSold+quantity;
	}
	public int getMexicanSold() {
		return MexicanSold;
	}
	public void incMexicanSold(int quantity) {
		MexicanSold=MexicanSold+quantity;
	}
	public int getSalesToday() {
		return SalesToday;
	}
	public void setSalesToday(int sales) {
		SalesToday = SalesToday+sales;
	}

	public void init()
	{
		dt=Date.valueOf(LocalDate.now());
		VegSold=0;
		NonVegSold=0;
		ItalianSold=0;
		MexicanSold=0;
		BillCount=0;
		SalesToday=0;
		
	}
}
