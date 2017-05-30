package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class TicketSales implements Runnable {  
	  private final CountDownLatch doneSignal;   
	  private final AtomicInteger tickets;
	  private String saleName;
	  
	  TicketSales(CountDownLatch doneSignal, String saleName,AtomicInteger tickets) { 
	     this.doneSignal = doneSignal;                   
	     this.saleName = saleName; 
	     this.tickets = tickets;
	  }         
	  public  void run() {                                
		  doSales(tickets);                                    
	  }                                                  
	  public  void  doSales(AtomicInteger tickets) { 
		 while(tickets.get()>0){
					   System.out.println(saleName+"卖完一张票，还有："+tickets.decrementAndGet()+"张");
			   }
		doneSignal.countDown();
	  }                              
}                                                    
	                                                     
