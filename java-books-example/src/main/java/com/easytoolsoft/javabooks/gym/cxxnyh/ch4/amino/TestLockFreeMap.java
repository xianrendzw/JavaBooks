package com.easytoolsoft.javabooks.gym.cxxnyh.ch4.amino;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.amino.ds.lockfree.LockFreeDictionary;
import org.junit.Test;

public class TestLockFreeMap {
	private static final int MAX_THREADS = 20;
	private static final int TASK_COUNT = 40;
	java.util.Random rand = new java.util.Random();

	private static Object DUMMY = new Object();
	Map map;

	public class AccessMapThread implements Runnable {
		protected String name;

		public AccessMapThread() {
		}

		public AccessMapThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 50000; i++)
					handleMap(rand.nextInt(1000));
				Thread.sleep(rand.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public class CounterPoolExecutor extends ThreadPoolExecutor {
		private AtomicInteger count = new AtomicInteger(0);
		public long startTime = 0;
		public String funcname = "";

		public CounterPoolExecutor(int corePoolSize, int maximumPoolSize,
				long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		}

		protected void afterExecute(Runnable r, Throwable t) {
			int l = count.addAndGet(1);
			if (l == TASK_COUNT) {
				System.out.println(funcname + " spend time:" + (System.currentTimeMillis() - startTime));

			}
		}
	}

	public Object handleMap(int index) {
		map.put(rand.nextInt(2000), DUMMY);
		return map.get(index);
	}

	public void initLockFreeMap() {
		map = new LockFreeDictionary();
		for (int i = 0; i < 1000; i++)
			map.put(i, DUMMY);
	}

	public void initTreeMap() {
		map = Collections.synchronizedMap(new TreeMap());
		for (int i = 0; i < 1000; i++)
			map.put(i, DUMMY);
	}

	@Test
	public void testLockFreeMap() throws InterruptedException {
		initLockFreeMap();
		CounterPoolExecutor exe = new CounterPoolExecutor(MAX_THREADS, MAX_THREADS,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		long starttime = System.currentTimeMillis();
		exe.startTime = starttime;
		exe.funcname = "testLockFreeMap";
		Runnable r = new AccessMapThread();
		for (int i = 0; i < TASK_COUNT; i++)
			exe.submit(r);

		Thread.sleep(10000);
	}

	// @Test
	public void testTreeMap() throws InterruptedException {
		initTreeMap();
		CounterPoolExecutor exe = new CounterPoolExecutor(MAX_THREADS, MAX_THREADS,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		long starttime = System.currentTimeMillis();
		exe.startTime = starttime;
		exe.funcname = "testTreeMap";
		Runnable r = new AccessMapThread();
		for (int i = 0; i < TASK_COUNT; i++)
			exe.submit(r);

		Thread.sleep(10000);
	}
}
