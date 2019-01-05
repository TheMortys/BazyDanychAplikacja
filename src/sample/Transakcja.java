package sample;

import java.sql.Date;

public class Transakcja {

	private Date date;
	private float amount;
	private KontoKlienta source;
	private KontoKlienta destination;
	private String category;
	private String name;
	
	public Transakcja(Date date, float amount, KontoKlienta source, KontoKlienta destination, String category,
			String name) {
	
		this.date = date;
		this.amount = amount;
		this.source = source;
		this.destination = destination;
		this.category = category;
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public KontoKlienta getSource() {
		return source;
	}
	
	public void setSource(KontoKlienta source) {
		this.source = source;
	}
	
	public KontoKlienta getDestination() {
		return destination;
	}
	
	public void setDestination(KontoKlienta destination) {
		this.destination = destination;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
