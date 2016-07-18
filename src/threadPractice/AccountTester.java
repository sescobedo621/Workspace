package threadPractice;

public class AccountTester extends Thread {
	private Account account = null;
	private double depositAmount = 0.0;

	public AccountTester(Account acc, double amt)
	{
		account = acc;
		depositAmount = amt;
	}

	public void run()
	{
		for (int i = 0; i < 1000; i++) {
			account.deposit(depositAmount);
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		Account acount = new Account(0.0);
		AccountTester test1 = new AccountTester(acount, 2);
		AccountTester test2 = new AccountTester(acount, 3);
		
		test1.start();
		test2.start();
		
		test1.join();
		test2.join();
		
		System.out.println("End Balance " + acount.getBalance());
	}
}
