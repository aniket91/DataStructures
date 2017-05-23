package com.osfg.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.osfg.models.BTreeNode;

/**
 * 
 * @author athakur Class to print pre order, post order, in order and level
 *         order btree traversals
 */
public class BTreePrinter {

	// Root - Left - Right
	public static void printPreOrderTraversal(BTreeNode root) {
		if (root != null)
			System.out.println(root.getData());

		if (root.getLeft() != null)
			printPreOrderTraversal(root.getLeft());
		if (root.getRight() != null)
			printPreOrderTraversal(root.getRight());
	}

	// Left - Right - Root
	public static void printPostOrderTraversal(BTreeNode root) {
		if (root.getLeft() != null)
			printPostOrderTraversal(root.getLeft());
		if (root.getRight() != null)
			printPostOrderTraversal(root.getRight());
		if (root != null)
			System.out.println(root.getData());
	}

	// Left - Root - Right
	public static void printInOrderTraversal(BTreeNode root) {
		if (root.getLeft() != null)
			printInOrderTraversal(root.getLeft());

		if (root != null)
			System.out.println(root.getData());

		if (root.getRight() != null)
			printInOrderTraversal(root.getRight());

	}

	private static Queue<BTreeNode> levelOrderQueue = new LinkedList();

	public static void printLevelOrderTraversal(BTreeNode root) {

		if (root == null) {
			return;
		}

		System.out.println(root.getData());

		if (root.getLeft() != null)
			levelOrderQueue.offer(root.getLeft());

		if (root.getRight() != null)
			levelOrderQueue.offer(root.getRight());

		if (!levelOrderQueue.isEmpty()) {
			printLevelOrderTraversal(levelOrderQueue.poll());
		} else {
			levelOrderQueue.clear();
		}

	}

	public static int getHeight(BTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = getHeight(root.getLeft());
			int rightHeight = getHeight(root.getRight());
			return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
		}
	}

	/**
	 * 
	 * @param root
	 *            if the btrr Worst case time complexity - O(N^2) for skewed
	 *            trees No extra space
	 */
	public static void printSpiralRecurssive(BTreeNode root) {
		boolean leftToRight = false;
		int height = getHeight(root);
		for (int i = 1; i <= height; i++) {
			printLevelRecurssive(root, i, leftToRight);
			leftToRight = !leftToRight;
		}

	}

	public static void printLevelRecurssive(BTreeNode root, int level, boolean leftToRight) {
		if (level == 1) {
			System.out.println(root.getData());
		} else {
			if (leftToRight) {
				printLevelRecurssive(root.getLeft(), level - 1, leftToRight);
				printLevelRecurssive(root.getRight(), level - 1, leftToRight);
			} else {
				printLevelRecurssive(root.getRight(), level - 1, leftToRight);
				printLevelRecurssive(root.getLeft(), level - 1, leftToRight);
			}

		}
	}

	private static Stack<BTreeNode> leftToRight = new Stack<>();
	private static Stack<BTreeNode> rightToLeft = new Stack<>();

	/**
	 * 
	 * @param root
	 *            if the btrr Time complexity - O(N) space complexity - O(N)
	 */
	public static void printSpiralIterative(BTreeNode root) {

		rightToLeft.push(root);

		while (!rightToLeft.isEmpty() && !leftToRight.isEmpty()) {
			while (!rightToLeft.isEmpty()) {
				BTreeNode node = rightToLeft.pop();
				System.out.println(node.getData());
				if (node.getLeft() != null) {
					leftToRight.push(node.getLeft());
				}
				if (node.getRight() != null) {
					leftToRight.push(node.getRight());
				}
			}

			while (!leftToRight.isEmpty()) {
				BTreeNode node = rightToLeft.pop();
				System.out.println(node.getData());
				if (node.getLeft() != null) {
					rightToLeft.push(node.getLeft());
				}
				if (node.getRight() != null) {
					rightToLeft.push(node.getRight());
				}
			}
		}

	}

}
