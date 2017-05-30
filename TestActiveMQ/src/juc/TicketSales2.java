package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class TicketSales2 implements Runnable { 
	  private static volatile AtomicBoolean isDoned = new AtomicBoolean(Boolean.TRUE);
	  private final CountDownLatch doneSignal;   
	  private final AtomicInteger tickets;
	  private String saleName;
	  
	  TicketSales2(CountDownLatch doneSignal, String saleName,AtomicInteger tickets) { 
	     this.doneSignal = doneSignal;                   
	     this.saleName = saleName; 
	     this.tickets = tickets;
	  }         
	  public  void run() {                                
		  doSales(tickets);                                    
	  }                                                  
	  public  void  doSales(AtomicInteger tickets) { 
		 while(isDoned.get()){
//			 synchronized
				System.out.println(saleName+"卖完一张票，还有："+tickets.decrementAndGet()+"张");
				if(tickets.get()==0){
					isDoned.compareAndSet(true, false);
				}
            }
		doneSignal.countDown();
	  }                              
}                                                    
	                                                     
