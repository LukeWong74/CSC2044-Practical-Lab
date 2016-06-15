import java.util.concurrent.locks.ReentrantLock;

public class Fork {
	ReentrantLock lock = new ReentrantLock();
	
	public Fork(){}
	
	public boolean pickFork(){
		return lock.tryLock();
	}
	
	public void placeFork(){
		lock.unlock();
	}
}
