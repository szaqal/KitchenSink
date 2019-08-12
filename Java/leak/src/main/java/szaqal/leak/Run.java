package szaqal.leak;

public class Run implements Runnable{

	public void run() {
		for (int i=0;i<10_000_000;i++) {
			new TestClass();
		}
		System.out.println(String.format("%s => %s", Thread.currentThread().getName(), "Done"));
	}
}
