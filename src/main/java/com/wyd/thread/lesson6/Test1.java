/*package com.wyd.thread.lesson6;

public class Test1 {
	java.util.concurrent.FutureTask.Sync.innerRun();

	void innerRun() { 
	    if (!compareAndSetState(0, RUNNING)) 
	        return; 
	    try { 
	        runner = Thread.currentThread(); 
	        if (getState() == RUNNING) // recheck after setting thread 
	            innerSet(callable.call()); 
	        else 
	            releaseShared(0); // cancel 
	    } catch (Throwable ex) { 
	        innerSetException(ex); 
	    } 
	} 

	void innerSetException(Throwable t) { 
	    for (;;) { 
	        int s = getState(); 
	        if (s == RAN) 
	            return; 
	        if (s == CANCELLED) { 
	            // aggressively release to set runner to null, 
	            // in case we are racing with a cancel request 
	            // that will try to interrupt runner 
	            releaseShared(0); 
	            return; 
	        } 
	        if (compareAndSetState(s, RAN)) { 
	            exception = t; 
	            result = null; 
	            releaseShared(0); 
	            done(); 
	            return; 
	        } 
	    } 
	}
}
*/