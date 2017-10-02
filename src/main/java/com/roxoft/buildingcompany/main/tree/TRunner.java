package com.roxoft.buildingcompany.main.tree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TRunner {
	private static final Logger lOGGER = LogManager.getLogger(TRunner.class);

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add(3.0);
		tree.add(1.5);
		tree.add(5.8);
		tree.add(3.3);
		tree.add(2.6);
		tree.add(5.9);
		tree.add(1.9);
		tree.add(2.8);
		tree.add(1.3);
		tree.add(1.3);
		tree.add(1.3);
		tree.print();
		tree.delete(2.6);
		tree.delete(5.8);
		tree.delete(3.0);
		lOGGER.info("New ");
		tree.print();
	}

}
