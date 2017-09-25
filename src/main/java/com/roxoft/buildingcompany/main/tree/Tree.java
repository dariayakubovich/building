package com.roxoft.buildingcompany.main.tree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tree {
	private static final Logger lOGGER = LogManager.getLogger(Tree.class);
	private Node root;

	public void add(double x) {
		root = addNode(root, x);
	}

	private Node addNode(Node node, double x) {
		if (node == null) {
			return new Node(x);
		}
		if (x < node.value) {
			node.left = addNode(node.left, x);
		} else if (x > node.value) {
			node.right = addNode(node.right, x);
		}
		return node;
	}

	public void print() {
		lOGGER.info("Binary Tree: ");
		printNode(root);
	}

	private void printNode(Node node) {
		if (node != null) {
			printNode(node.left);
			lOGGER.info(node.value);
			lOGGER.info("  ");
			printNode(node.right);
		}
	}

	public void delete(Double value) {
		deleteNode(root, value);
	}

	private Node deleteNode(Node root, double x) {
		if (root == null) {
			return root;
		}
		if (x < root.value) {
			root.left = deleteNode(root.left, x);
		} else if (x > root.value) {
			root.right = deleteNode(root.right, x);
		} else if (root.left != null && root.right != null) {
			root.value = (minimum(root.right)).value;
			root.right = deleteNode(root.right, root.value);
		} else if (root.left != null && root.right == null) {
			root = root.left;
		} else if (root.left == null && root.right != null) {
			root = root.right;
		} else {
			root = null;
		}
		return root;
	}

	private Node minimum(Node x) {
		if (x.left == null) {
			return x;
		} else {
			return minimum(x.left);
		}
	}

}
