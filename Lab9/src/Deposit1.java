
public class Deposit1 implements Runnable{
	Bank b1;
	
	public Deposit1(Bank b1){
		this.b1 = b1;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(b1){
				System.out.printf("User1 deposits $10 to balance: $%d\n\n" , b1.deposit(10));
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
