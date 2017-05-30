package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnerGames {
	public static void main(String[] args) {
		   CountDownLatch startSignal = new CountDownLatch(1);
		   CountDownLatch doneSignal = new CountDownLatch(3);
		   ExecutorService  exec = Executors.newCachedThreadPool();
		   RunnableMan rm1 = new RunnableMan(startSignal,doneSignal, 1000);
		   RunnableMan rm2 = new RunnableMan(startSignal,doneSignal, 2000);
		   RunnableMan rm3 = new RunnableMan(startSignal,doneSignal, 3000);
		   Future<Integer> score1 = exec.submit(rm1);
		   Future<Integer> score2 = exec.submit(rm2);
		   Future<Integer> score3 = exec.submit(rm3);
		   System.out.println("开始赛跑......");
		   startSignal.countDown();
		   try {
			   doneSignal.await();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}  
		   int sumScores =0;
		   try {
			   try {
				sumScores  = score1.get()+score2.get()+score3.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		   System.out.println("团队赛跑结束,最后成绩为："+sumScores);
		   exec.shutdown();
		 }
}
