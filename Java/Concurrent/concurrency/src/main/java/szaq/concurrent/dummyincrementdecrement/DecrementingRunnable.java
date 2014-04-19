package szaq.concurrent.dummyincrementdecrement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pmalczyk on 4/19/14.
 */
public class DecrementingRunnable implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(DecrementingRunnable.class);


    private int security;

    public DecrementingRunnable(int security) {
        this.security = security;
    }


    @Override
    public void run() {
        LOG.debug(" Run " + Thread.currentThread().getId());

        for (int i = 0; i < 1000000; i++) {
            if (security == 2) {
                SharedResource.fullLockDecrement();
            } else if (security ==1) {
                SharedResource.halfLockDecrement();
            } else if (security ==3){
                SharedResource.threadLocalDecrement();
            } else {
                SharedResource.decrement();
            }
        }

        LOG.debug(" Done " + SharedResource.getValue() + " " + Thread.currentThread().getId());
    }
}
