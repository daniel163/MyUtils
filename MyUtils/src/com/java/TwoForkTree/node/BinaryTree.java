package com.java.TwoForkTree.node;

import java.util.Stack;

/****
 * java版的二叉树的先序遍历、中序遍历以及后序遍历(递归以及非递归方式)
 * @author zhanghengWin
 *
 */
public class BinaryTree {
	
	 /**
	   * @author 行者摩罗
	   * 二叉树的先序中序后序排序
	   */
	  public Node init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
	    Node J = new Node(8, null, null);
	    Node H = new Node(4, null, null);
	    Node G = new Node(2, null, null);
	    Node F = new Node(7, null, J);
	    Node E = new Node(5, H, null);
	    Node D = new Node(1, null, G);
	    Node C = new Node(9, F, null);
	    Node B = new Node(3, D, E);
	    Node A = new Node(6, B, C);
	    return A;   //返回根节点
	  }
	  
	  public void printNode(Node node){
	    System.out.print(node.getData());
	  }
	  /*
	  public void theFirstTraversal(Node root) {  //先序遍历
	    printNode(root);
	    if (root.getLeftNode() != null) {  //使用递归进行遍历左孩子
	      theFirstTraversal(root.getLeftNode());
	    }
	    if (root.getRightNode() != null) {  //递归遍历右孩子
	      theFirstTraversal(root.getRightNode());
	    }
	  }
	  public void theInOrderTraversal(Node root) {  //中序遍历
	    if (root.getLeftNode() != null) {
	      theInOrderTraversal(root.getLeftNode());
	    }
	    printNode(root);
	    if (root.getRightNode() != null) {
	      theInOrderTraversal(root.getRightNode());
	    }
	  }
	  public void thePostOrderTraversal(Node root) {  //后序遍历
	    if (root.getLeftNode() != null) {
	      thePostOrderTraversal(root.getLeftNode());
	    }
	    if(root.getRightNode() != null) {
	      thePostOrderTraversal(root.getRightNode());
	    }
	    printNode(root);
	  }*/
	  
	  public static void main(String[] args) {
	    BinaryTree tree = new BinaryTree();
	    Node root = tree.init();
	    
	    /***
	     * 遞歸
	     */
	    /*System.out.println("先序遍历");
	    tree.theFirstTraversal(root);
	    System.out.println("");
	    System.out.println("中序遍历");
	    tree.theInOrderTraversal(root);
	    System.out.println("");
	    System.out.println("后序遍历");
	    tree.thePostOrderTraversal(root);
	    System.out.println("");*/
	    
	    
	    /***
	     * 非遞歸
	     */
	    System.out.println("先序遍历");
	    tree.theFirstTraversal_Stack(root);
	    System.out.println("");
	    
	    System.out.println("中序遍历");
	    tree.theInOrderTraversal_Stack(root);
	    System.out.println("");
	    
	    System.out.println("后序遍历");
	    tree.thePostOrderTraversal_Stack(root);
	    System.out.println("");
	  }
	  
	  
	  
	  
	//===============采用非递归方式========================
	  
	  public void theFirstTraversal_Stack(Node root) {  //先序遍历
	    Stack<Node> stack = new Stack<Node>();
	    Node node = root;
	    while (node != null || stack.size() > 0) {  //将所有左孩子压栈
	      if (node != null) {   //压栈之前先访问
	        printNode(node);
	        stack.push(node);
	        node = node.getLeftNode();
	      } else {
	        node = stack.pop();
	        node = node.getRightNode();
	      }
	    }
	  }
	  
	  /****
	   * 中序遍歷
	   * @param root
	   */
	  public void theInOrderTraversal_Stack(Node root) {  //中序遍历
	    Stack<Node> stack = new Stack<Node>();
	    Node node = root;
	    while (node != null || stack.size() > 0) {
	      if (node != null) {
	        stack.push(node);   //直接压栈
	        node = node.getLeftNode();
	      } else {
	        node = stack.pop(); //出栈并访问
	        printNode(node);
	        node = node.getRightNode();
	      }
	    }
	  }
	  
	  public void thePostOrderTraversal_Stack(Node root) {   //后序遍历
	    Stack<Node> stack = new Stack<Node>();
	    Stack<Node> output = new Stack<Node>();//构造一个中间栈来存储逆后序遍历的结果
	    Node node = root;
	    while (node != null || stack.size() > 0) {
	      if (node != null) {
	        output.push(node);
	        stack.push(node);				
	        node = node.getRightNode();
	      } else {
	        node = stack.pop();				
	        node = node.getLeftNode();
	        
	      }
	    }
	    while (output.size() > 0) {
	      printNode(output.pop());
	    }
	  }
	  
	
}
