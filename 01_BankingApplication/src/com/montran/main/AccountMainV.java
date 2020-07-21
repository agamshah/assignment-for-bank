package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Account;
import com.montran.pojo.Current;
import com.montran.pojo.Savings;


public class AccountMainV {
	
	Scanner s = new Scanner(System.in);
	double overDraftLimit = 1;
	String overdraftchoice = "yes";
	String name;
	int accountNumber;
	double balance;

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		AccountMainV accounMainV = new AccountMainV();

		int accountChoice;
		boolean isSalary = false;
		
		System.out.println("Welcome To State Bank of INDIA");
		System.out.println("Please Select Account Type");
		System.out.println("1.Savings");
		System.out.println("2.Current");
		System.out.println("Your Choice: ");
		accountChoice = sc.nextInt();
		switch (accountChoice) {
		case 1: {
			System.out.println("Is It a salary account please enter (true or false)");
			isSalary = sc.nextBoolean();
			accounMainV.saving(isSalary);
			break;
		}
		case 2: 
		{
			accounMainV.cur();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + accountChoice);
		}
	
	}
	

	public void cur() 
	{
		int transactionChoice;
		String continueChoice ="yes";
		do
		{
		System.out.println("Please Enter Over Draft Limit");
		overDraftLimit = s.nextInt();
		if (overDraftLimit <= 0) 
		{
			System.out.println("Please Enter a Valid Number");
		} 
		else 
		{
			System.out.println("Over Draft Limit Entered By You is : " + overDraftLimit);
		}
		System.out.println("Do you Wish to enter again type (Yes / NO)");
		overdraftchoice = s.next();
	}while(overdraftchoice.equals("yes"));
		do
		{
		if(overDraftLimit > 0)
		{
			System.out.println("Please Enter Basic Details");
			System.out.println("Please Enter Name");
			name = s.next();
			System.out.println("Please Enter Account Number");
			accountNumber = s.nextInt();
			System.out.println("Please Enter Balance");
			balance = s.nextInt();
			System.out.println("Account Created Successfully");
			System.out.println("Account Holder Name: " +name+ " Account Number: " +accountNumber+ " Account Balance is: " +balance+ " OverDraft Limit is: " +overDraftLimit);
			break;
		}
		else
		{
			break;
		}
		}while(overdraftchoice.equals("yes"));
		
		Current current = new Current(accountNumber,name,balance,overDraftLimit);
		do {
			System.out.println("Enter your choice");
			System.out.println("Menu");
			System.out.println("1.withdraw");
			System.out.println("2.deposit");
			System.out.println("3.balance");
			transactionChoice = s.nextInt();
			
			switch (transactionChoice) {
			case 1: {
				System.out.println("Enter amount to withdraw");
				double amount = s.nextDouble();
				boolean amt = current.withdraw(amount);
				if(amt)
				{
					System.out.println("Transation Successful !!");
					System.out.println(current);
				}
				if(!amt) 
				{
					System.out.println("failed");
					break;
				}
				break;
			}
			case 2:
			{
				System.out.println("Enter Amount To Deposit");
				double depositAmount = s.nextDouble();
				boolean depo = current.deposit(depositAmount);
				if(depo)
				{
					System.out.println("Transaction Successful");
					System.out.println(current);
				}
				if(!depo)
				{
					System.out.println("Transaction Failed");
				}
				break;
			}
			case 3:
			{
				System.out.println("Account Holder Name: " +name);
				System.out.println("Account Number: " +accountNumber);
				System.out.println("Account Balance: "+current.getBalance());
				System.out.println("Account OverDraftBalaance: "+current.getOverDraftBalance());
			}
			default:
				
			}
			System.out.println("Do you want to continue: ");
			continueChoice=s.next();
		} while (continueChoice.equals("yes"));
		System.out.println("Thank You for Visiting. See you soon");
	}
	public void saving(Boolean isSalary)
	{
		int choiceForTransaction;
		String continueChoice;
		int amt;
		
		System.out.println("Enter Basic Details");
		System.out.println("Enter Name: ");
		name=s.next();
		System.out.println("Enter Account Number");
		accountNumber=s.nextInt();
		System.out.println("Enter Balance");
		balance=s.nextDouble();
		
		Savings savings = new Savings(accountNumber, name, balance, isSalary);
		
			do {
				System.out.println("Menu");
				System.out.println("1. Withdraw");
				System.out.println("2. Deposit");
				System.out.println("3. Balance");
				System.out.println("Enter your choice");
				choiceForTransaction = s.nextInt();
				switch (choiceForTransaction) {
				case 1: {
					System.out.println("Enter Amount To Withdraw");
					amt=s.nextInt();
					boolean withdrawflag=savings.withdraw(amt);
					if(withdrawflag) {
						System.out.println("Transaction Successfull !!.");
						System.out.println(savings);
					}
					if(!withdrawflag)
					{
						System.out.println("Transaction Failed!");
					}
						break;
				}
				case 2:
				{
					System.out.print("Enter amount to Deposit: ");
					amt=s.nextInt();
					boolean savingbol=savings.deposit(amt);
					if(savingbol) 
					{
						System.out.println("Transaction Successfull!!.");
						System.out.println(savings);
					}
					if(!savingbol)
					{
						System.out.println("Transaction Failed!!.");
					}
					break;
				}
				case 3:
				{
					System.out.println("Account Balance for the Account Holder Name: "+name+" is "+balance);
				}
				default:
					break;
				}
				System.out.println("Do you Want To Continue Enter (YES/NO)");
				continueChoice=s.next();
			} while (continueChoice.toLowerCase().equals("yes"));
			
		}
}
