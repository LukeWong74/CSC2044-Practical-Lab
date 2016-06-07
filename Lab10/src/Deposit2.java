
public class Deposit2 implements Runnable{
	Bank b1;
	
	public Deposit2(Bank b1){
		this.b1 = b1;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.printf("User2 deposits $20 to balance: $%d\n\n" , b1.deposit(20));
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
