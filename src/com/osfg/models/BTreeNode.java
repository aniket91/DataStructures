package com.osfg.models;


/**
 * 
 * @author athakur
 * Model class for tree node
 */
public class BTreeNode {
	
	int data;
	BTreeNode left;
	BTreeNode right;
	
	public BTreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BTreeNode getLeft() {
		return left;
	}

	public void setLeft(BTreeNode left) {
		this.left = left;
	}

	public BTreeNode getRight() {
		return right;
	}

	public void setRight(BTreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "BTreeNode [data=" + data + "]";
	}	

}
