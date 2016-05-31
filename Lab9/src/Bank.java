import java.util.concurrent.atomic.AtomicInteger;


public class Bank {
	AtomicInteger balance;
	int value;
	
	public Bank(int value){
		this.value = value;
		this.balance = new AtomicInteger(value);
	}
	
	public synchronized int deposit(int value){
		this.notifyAll();
		return balance.addAndGet(value);
	}
	public synchronized int withdraw(int value){
		if(balance() < value){
			try {
				System.out.println("The withdraw amount is greater than available balance.\n");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return balance.addAndGet(-value);
	}
	
	public int balance(){
		return balance.get();
	}
}
