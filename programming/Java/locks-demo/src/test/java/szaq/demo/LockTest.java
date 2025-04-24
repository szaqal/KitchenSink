package szaq.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LockTest {

  private static final Logger log = LoggerFactory.getLogger(LockTest.class);

  @Test
  void lock() throws InterruptedException {

    Lock lock = new ReentrantLock();

    Thread withDelayedLock = new Thread(() -> {
      lock.lock();
      log.info("Acquired delayed");
      lock.unlock();
      log.info("Finished");
    });

    lock.lock();
    withDelayedLock.start();
    log.info("Start");
    Thread.sleep(1500);
    log.info("Will release");
    lock.unlock();
  }

  @Test
  void lockInterruptibly() throws InterruptedException {

    Lock lock = new ReentrantLock();

    Thread withDelayedLock = new Thread(() -> {
      try {
        lock.lockInterruptibly(); // <--  here
      } catch ( InterruptedException e ) {
        log.error("interrupted while waiting", e);
      }
    });

    lock.lock();
    withDelayedLock.start();
    withDelayedLock.interrupt();
    lock.unlock();
  }

  @Test
  void tryLock() throws InterruptedException {
    Lock lock = new ReentrantLock();

    Thread withDelayedLock = new Thread(() -> {
      boolean locked = lock.tryLock();
      assertFalse(locked);
    });

    lock.lock();
    withDelayedLock.start();
    Thread.sleep(500);
    lock.unlock();
    withDelayedLock.join();
  }

  @Test
  void tryLockTime() throws InterruptedException {
    Lock lock = new ReentrantLock();
    Thread withDelayedLock = new Thread(() -> {
      try {
        boolean locked = lock.tryLock(100, TimeUnit.MILLISECONDS);
        assertFalse(locked);
      } catch ( InterruptedException e ) {
        throw new RuntimeException(e);
      }
    });

    lock.lock();
    withDelayedLock.start();
    Thread.sleep(500);
    lock.unlock();
    withDelayedLock.join();
  }
}
