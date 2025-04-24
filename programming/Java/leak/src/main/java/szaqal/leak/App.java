package szaqal.leak;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(100);
		for(int i=0;i<50;i++) {
			newFixedThreadPool.execute(new Run());
		}
		newFixedThreadPool.awaitTermination(60, TimeUnit.MINUTES);
		newFixedThreadPool.isShutdown();

	}
}
