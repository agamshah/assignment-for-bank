/**
 * 
 */
package com.montran.pojo;

public class Account {
	// instance variable 
	private int accountNumber;
	private String name;
	private double balance;
	
	public Account(int accountNumber, String name, double balance)
	{
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		
	}
	public Account() {
		// TODO Auto-generated constructor stub
		System.out.println("This is default constructor");
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean deposit(double amount) {
		if(amount > 0 ) {
			balance = balance + amount;			
			return true;
		}
		return false;
	}
	public boolean withdraw(double amount) {
		if(amount > 0 && amount <= balance)
		{
			balance = balance - amount;
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
