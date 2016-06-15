
public class Philosopher implements Runnable{
	Fork lefthand, righthand;
	String person;
	
	public Philosopher(Fork lefthand, Fork righthand, String person){
		this.lefthand = lefthand;
		this.righthand = righthand;
		this.person = person;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				if(righthand.pickFork()){
					if(lefthand.pickFork() && righthand.pickFork()){
						System.out.println(person + " is eating for 3 seconds.");
		
						Thread.sleep(3000);
						lefthand.placeFork();
						righthand.placeFork();
					}
					else{
						System.out.println(person + " keeps the right fork.");
					}
					
					Thread.sleep(1000);
				}
				else{
					System.out.println(person + " has no fork.");
					Thread.sleep(1000);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
