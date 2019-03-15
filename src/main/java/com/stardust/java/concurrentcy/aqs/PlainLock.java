package com.stardust.java.concurrentcy.aqs;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class PlainLock {

    private static class Sync extends AbstractQueuedSynchronizer {

        /**
		 * 
		 */
		private static final long serialVersionUID = -3325656051124738672L;

		@Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private Sync sync = new Sync();


    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }
}