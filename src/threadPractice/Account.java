package threadPractice;

public class Account {
	private double balance;
	
	public Account(double initialBalance){
		balance = initialBalance;
	}
	
	public void deposit(double amount){
		synchronized(this){
			balance += amount;
		}
	}
	
	public void withdrawl(double amount){
		balance -= amount;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}
}
