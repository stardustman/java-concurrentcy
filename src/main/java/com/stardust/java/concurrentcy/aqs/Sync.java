package com.stardust.java.concurrentcy.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Sync extends AbstractQueuedSynchronizer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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