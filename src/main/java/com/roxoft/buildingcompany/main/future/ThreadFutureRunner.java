package com.roxoft.buildingcompany.main.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.Runner;

public class ThreadFutureRunner {
	private static final Logger lOGGER = LogManager.getLogger(ThreadFutureRunner.class);

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		//CompletableFuture<String> completableFuture = new CompletableFuture<>();
		Runner.repeat(3, () -> executor.execute(new ThreadFuture()));
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		lOGGER.info("Finished all threads");
	}

}
