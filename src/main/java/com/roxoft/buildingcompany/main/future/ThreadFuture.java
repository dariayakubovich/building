package com.roxoft.buildingcompany.main.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadFuture implements Runnable {
	private static final Logger lOGGER = LogManager.getLogger(ThreadFuture.class);
	CompletableFuture<String> completableFuture;

	@Override
	public void run() {
		lOGGER.info(Thread.currentThread().getName() + " start work");
		Future<String> completableFuture = futureExample("Dasha");
		try {
			lOGGER.info(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			lOGGER.info(e.getMessage());
		}
		lOGGER.info(Thread.currentThread().getName() + " finish work");
	}

	public Future<String> futureExample(String s) {
		String result = s + "!";
		return CompletableFuture.completedFuture(result);
	}
}
