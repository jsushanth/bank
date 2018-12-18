package com.capgemini.bank.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class DemandDraft implements Serializable {

	private int transaction_id;
	
	private String customer_name;
	
	private String in_favor_of;
	
	private String phone_number;
private LocalDate date_of_transaction;
	private double dd_amount;
	
	private double dd_commission;
	
	private String dd_description;
	public DemandDraft() {
		
	}
	public DemandDraft(int transaction_id, String customer_name, String in_favor_of, String phone_number,LocalDate date_of_transaction, double dd_amount, double dd_commission, String dd_description) {
		super();
		this.transaction_id = transaction_id;
		this.customer_name = customer_name;
		this.in_favor_of = in_favor_of;
		this.phone_number = phone_number;
		this.date_of_transaction=date_of_transaction;
		this.dd_amount = dd_amount;
		this.dd_commission = dd_commission;
		this.dd_description = dd_description;
		
	}

	public DemandDraft(String customer_name, String in_favor_of, String phone_number,LocalDate date_of_transaction,double dd_amount, double dd_commission, String dd_description) {
		super();
		this.customer_name = customer_name;
		this.in_favor_of = in_favor_of;
		this.phone_number = phone_number;
		this.date_of_transaction=date_of_transaction;
		this.dd_amount = dd_amount;
		this.dd_commission = dd_commission;
		this.dd_description = dd_description;
	}

	
	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getIn_favor_of() {
		return in_favor_of;
	}

	public void setIn_favor_of(String in_favor_of) {
		this.in_favor_of = in_favor_of;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public LocalDate getDate_of_transaction() {
		return date_of_transaction;
	}
	public void setDate_of_transaction(LocalDate date_of_transaction) {
		this.date_of_transaction = date_of_transaction;
	}
	public double getDd_amount() {
		return dd_amount;
	}

	public void setDd_amount(double dd_amount) {
		this.dd_amount = dd_amount;
	}

	public double getDd_commission() {
		return dd_commission;
	}

	public void setDd_commission(double dd_commission) {
		this.dd_commission = dd_commission;
	}

	public String getDd_description() {
		return dd_description;
	}

	public void setDd_description(String dd_description) {
		this.dd_description = dd_description;
	}
	@Override
	public String toString() {
		return "DemandDraft [transaction_id=" + transaction_id + ", customer_name=" + customer_name + ", in_favor_of="
				+ in_favor_of + ", phone_number=" + phone_number + ", date_of_transaction=" + date_of_transaction
				+ ", dd_amount=" + dd_amount + ", dd_commission=" + dd_commission + ", dd_description=" + dd_description
				+ "]";
	}

	

	

	
	
	
	
}
