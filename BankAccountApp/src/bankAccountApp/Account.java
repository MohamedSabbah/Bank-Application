package bankAccountApp;

import javax.management.loading.PrivateClassLoader;

public abstract class Account implements IBaseRate {
	// List common properties for saving and checking accounts
	private String name;
	private String sSN;
	private double balance;

	static int index = 10000;
	protected String accountNumber;
	protected double rate;

	// Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double balance) {
		super();
		this.name = name;
		this.sSN = sSN;
		this.balance = balance;

		// Set Account Number
		index++;
		this.accountNumber = SetAcountnumber();

		setRate();
	}

	public abstract void setRate();

	private String SetAcountnumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}

	public void compound() {
		double accruodInterest = balance + (rate / 100);
		balance = balance + accruodInterest;
		System.out.println("Accourd Innterest: $" + accruodInterest);
		printBalance();
	}
	// List common methods - transactions

	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}

	public void withdraw(double amount) {
		balance = balance + amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}

	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}

	public void printBalance() {
		System.out.println("Your Balance is now: $" + balance);
	}

	public void showInfo() {
		System.out.println("NAME: " + name + "\nACCOUNT NUMBER: " + accountNumber + "\nBALANCE: " + balance + "\nRate: "
				+ rate + "%"

		);
	}
}
