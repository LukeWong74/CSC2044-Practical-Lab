
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    AtomicInteger balance;

    public Bank(int value){
        this.balance = new AtomicInteger(value);
    }

    public int deposit(int value){
        lock.lock();
        
        try{
            int value1 = balance.addAndGet(value);
            condition.signalAll();
            return value1;
        } finally{
            lock.unlock();
        }
    }
    
    public int withdraw(int value) throws InterruptedException{
        lock.lock();
        try {
            while(balance.get() < value){
                System.out.println("The withdraw amount is greater than available balance.\n");

                condition.await();
            }
            
            return balance.addAndGet(-value);
        } 
        finally{
            lock.unlock();
        }
    }

    public int balance(){
        return balance.get();
    }
}
