package com.montran.pojo;

public class Current extends Account {

	private double overDraft;
	private double initialoverDraft;

	public Current() {
		// TODO Auto-generated constructor stub
	}

	public Current(int accountNumber, String name, double balance, double overDraftBalance) {
		super(accountNumber, name, balance);
		this.overDraft = overDraftBalance;
		this.initialoverDraft = overDraftBalance;
	}

	public double getOverDraftBalance() {
		return overDraft;
	}

	public void setOverDraftBalance(int overDraftBalance) {
		this.overDraft = overDraftBalance;
	}

	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		if (amount > 0) {
			if (amount <= getBalance()) {
				setBalance(getBalance() - amount);
				return true;
			}
			if (amount > getBalance()) {
				amount = amount - getBalance();
				setBalance(getBalance() - getBalance());
				overDraft = overDraft - amount;
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub

		if (overDraft != initialoverDraft) {
			double newdraftBalance = initialoverDraft - overDraft;
			if (newdraftBalance < amount) {
				overDraft = overDraft + newdraftBalance;
				amount = amount - newdraftBalance;
				setBalance(amount + getBalance());
				return true;
			}
			if (newdraftBalance >= amount) {
				overDraft = overDraft + amount;
				return true;
			}
		} else {
			setBalance(amount + getBalance());
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Current [overDraftBalance=" + overDraft + ", getAccountNumber()=" + getAccountNumber() + ", getName()="
				+ getName() + ", getBalance()=" + getBalance() + ", toString()=" + super.toString() + "]";
	}

}
