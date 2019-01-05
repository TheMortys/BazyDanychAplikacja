package sample;

import java.sql.Date;

public class Pozyczka {

	private float amount;
	private Date startDate;
	private Date endDate;
	private float interestRate;
	private float toRepay;
	private float installment;
	
	public Pozyczka(float amount, Date startDate, Date endDate, float interestRate, float toRepay, float installment) {
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.interestRate = interestRate;
		this.toRepay = toRepay;
		this.installment = installment;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getToRepay() {
		return toRepay;
	}

	public void setToRepay(float toRepay) {
		this.toRepay = toRepay;
	}

	public float getInstallment() {
		return installment;
	}

	public void setInstallment(float installment) {
		this.installment = installment;
	}
	
}
