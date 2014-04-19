package szaq.concurrent.dummyincrementdecrement;

/**
 * Created by pmalczyk on 4/19/14.
 */
public class SharedResource {

    private static int counter = 0;

    private static ThreadLocal<Integer> counterThreadLocal = new ThreadLocal<Integer>() {
        @Override
        public Integer get() {
            return counter;
        }
    };

    public static void increment() {
        counter ++;
    }

    public static void decrement() {
        counter --;
    }

    public static int getValue() {
        return counter;
    }

    public static void reset() {
        counter = 0;
    }

    public static void fullLockIncrement() {
        synchronized (SharedResource.class) {
            decrement();
        }
    }

    public static void fullLockDecrement() {
        synchronized (SharedResource.class) {
            increment();
        }
    }

    public static synchronized void halfLockIncrement() {
        increment();
    }

    public static synchronized void halfLockDecrement() {
        decrement();
    }

    public static void threadLocalIncrement() {
        counterThreadLocal.set(counterThreadLocal.get()+1);
    }

    public static void threadLocalDecrement() {
        counterThreadLocal.set(counterThreadLocal.get()-1);
    }

}
