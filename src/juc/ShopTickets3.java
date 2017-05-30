package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ShopTickets3 {
	/**
	 * AtomicInteger，一个提供原子操作的Integer的类。 在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，
	 * 不可避免的会用到synchronized关键字。而AtomicInteger则通过一种线程安全的加减操作接口。
	 */
	private static volatile AtomicInteger tickets = new AtomicInteger(10);
	private static volatile Object saleLock = new Object();
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch doneSignal = new CountDownLatch(3);
		Executor exec = Executors.newCachedThreadPool();
		exec.execute(new TicketSales3(doneSignal, "售票员1", tickets,saleLock));
		exec.execute(new TicketSales3(doneSignal, "售票员2", tickets,saleLock));
		exec.execute(new TicketSales3(doneSignal, "售票员3", tickets,saleLock));
		doneSignal.await();
		System.out.println("票已售完,所有售票员，停止售票");
	}
}
