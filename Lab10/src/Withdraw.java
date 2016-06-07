
import java.util.Random;

public class Withdraw implements Runnable{
	Bank b1;
	Random rand = new Random();
	
	public Withdraw(Bank b1){
		this.b1 = b1;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			int withdrawvalue = rand.nextInt(50 - 30 + 1) + 30;

            try {
				System.out.printf("User3 withdraws $%d from balance: $%d\n\n", withdrawvalue, b1.withdraw(withdrawvalue));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
