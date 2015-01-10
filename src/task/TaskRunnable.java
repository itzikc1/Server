package task;

import java.util.concurrent.atomic.AtomicInteger;


public class TaskRunnable implements Runnable {
	private Task t;
	AtomicInteger count;
	
	
	public TaskRunnable(Task t) {
		this.t = t;
		count=new AtomicInteger(0);
	}
	@Override
	public void run() {
		t.doTask();
		inc();
	}
	public void inc(){
		// count++;
		count.incrementAndGet();
		}
	public int getCount() {
		return count.get();
		}
}

