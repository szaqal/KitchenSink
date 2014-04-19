package szaq.concurrent.dummyincrementdecrement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pmalczyk on 4/19/14.
 */
public class IncrementingRunnable implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(DecrementingRunnable.class);

    private int security;

    public IncrementingRunnable(int security) {
        this.security = security;
    }

    @Override
    public void run() {

        LOG.debug(" Run " + Thread.currentThread().getId());

        for (int i = 0; i < 1000000; i++) {
            if(security==2){
                SharedResource.fullLockIncrement();
            } else if(security ==1) {
                SharedResource.halfLockIncrement();
            }  else if (security ==3){
                SharedResource.threadLocalIncrement();
            } else {
                SharedResource.increment();
            }
        }

       LOG.debug(" Done " + SharedResource.getValue() + " " + Thread.currentThread().getId());
    }
}
