package sample;

import java.sql.Date;

public class KontoKlienta {
	
	private float accountBalance;
	private Date date;
	
	public KontoKlienta(float accountBalance, Date date) {
		this.accountBalance = accountBalance;
		this.date = date;
	}
	
	public float getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}


}
