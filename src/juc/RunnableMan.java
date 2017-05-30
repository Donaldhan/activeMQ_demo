package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class RunnableMan implements Callable<Integer> {  
	  private final CountDownLatch startSignal;
	  private final CountDownLatch doneSignal;             
	  private final int i;                                 
	  RunnableMan(CountDownLatch startSignal,CountDownLatch doneSignal, int i) {   
		 this.startSignal = startSignal;
	     this.doneSignal = doneSignal;                     
	     this.i = i;                                       
	  }                                                    
	  public Integer call() {        
	     try {
	    	startSignal.await();
			doRun(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}                                      
	     doneSignal.countDown();
	     return new Integer(i);
	  }                                                    
	  void doRun(int i) throws InterruptedException { 
		  System.out.println("选手"+i/1000+"正在赛跑中........");
		  Thread.sleep(i*2);
	  }                             
}                                                      

