package szaqal.leak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run implements Runnable{
	
	private static final List<TestClass> leak = new ArrayList<>();
	
	private static final Random rand = new Random();

	public void run() {
		for (int i=0;i<10_000_000;i++) {
			new TestClass();
			if(rand.nextDouble()>0.98) {
				leak.add(new TestClass());
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(String.format("%s => %s", Thread.currentThread().getName(), "Done"));
	}
}
