
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b1 = new Bank(100);
		Deposit1 d1 = new Deposit1(b1);
		Deposit2 d2 = new Deposit2(b1);
		Withdraw w1 = new Withdraw(b1);
		
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		Thread t3 = new Thread(w1);
		
		System.out.println("Initial Balance: " + b1.balance());
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
