package com.java.TwoForkTree.node2;

/***
 * java版的二叉树的先序遍历、中序遍历以及后序遍历(递归以及非递归方式)
 * @author zhanghengWin
 *
 */
public class Node {
	
	private String data;
	private Node leftNode;
	private Node rightNode;
	
	public Node(String data, Node leftNode, Node rightNode){
	    this.data = data;
	    this.leftNode = leftNode;
	    this.rightNode = rightNode;
	  }

	  public String getData() {
	    return data;
	  }
	  public void setData(String data) {
	    this.data = data;
	  }
	  public Node getLeftNode() {
	    return leftNode;
	  }
	  public void setLeftNode(Node leftNode) {
	    this.leftNode = leftNode;
	  }
	  public Node getRightNode() {
	    return rightNode;
	  }
	  public void setRightNode(Node rightNode) {
	    this.rightNode = rightNode;
	  }

}
