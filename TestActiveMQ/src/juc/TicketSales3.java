package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class TicketSales3 implements Runnable {  
	  private final CountDownLatch doneSignal;   
	  private final AtomicInteger tickets;
	  private final Object saleLock;
	  private String saleName;
	  
	  TicketSales3(CountDownLatch doneSignal, String saleName,AtomicInteger tickets, Object saleLock) { 
	     this.doneSignal = doneSignal;                   
	     this.saleName = saleName; 
	     this.tickets = tickets;
	     this.saleLock = saleLock;
	  }         
	  public  void run() {                                
		  doSales(tickets);                                    
	  }                                                  
	  public  void  doSales(AtomicInteger tickets) { 
		 boolean flag = true;
		 while(flag){
			 synchronized(saleLock){
				   if(tickets.get()>0){
					   System.out.println(saleName+"卖完一张票，还有："+tickets.decrementAndGet()+"张");
					   saleLock.notifyAll();
				   }
				   else{
					   flag= false;
				   }
			   }
            }
		doneSignal.countDown();
	  }                              
}                                                    
	                                                     
