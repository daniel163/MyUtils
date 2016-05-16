package com.java.TwoForkTree.node2;

import java.util.Stack;

/****
 * java��Ķ������������������������Լ��������(�ݹ��Լ��ǵݹ鷽ʽ)
 * @author zhanghengWin
 *
 */
public class BinaryTree {
	
	 /**
	   * @author ����Ħ��
	   * �����������������������
	   */
	  public Node init() {//ע��������������Ƚ����ӽڵ㣬���������Ͻ�������Ϊ��Ҷ�ӽ���ʹ�õ�����Ľڵ㣬����ʼ���ǰ�˳���ʼ���ģ����������ᱨ��
	    //Node s9 = new Node("I", null, null);
		Node s9 = new Node("", null, null); 
	    Node s8 = new Node("E", null, null);  	//4
	    Node s7 = new Node("B", null, null);  	//2
	    Node s6 = new Node("G", null, s9);   	//7
	    Node s5 = new Node("C", s8, null);  	//5
	    Node s4 = new Node("A", null, s7);  	//1
	    //Node s3 = new Node("H", s6, null);
	    Node s3 = new Node("", s6, null);
	    Node s2 = new Node("D", s4, s5); 		//3
	    Node s1 = new Node("F", s2, s3);   		//6
	    return s1;   //���ظ��ڵ�
	  }
	  
	  public void printNode(Node node){
	    System.out.print(node.getData());
	  }
	  /*
	  public void theFirstTraversal(Node root) {  //�������
	    printNode(root);
	    if (root.getLeftNode() != null) {  //ʹ�õݹ���б�������
	      theFirstTraversal(root.getLeftNode());
	    }
	    if (root.getRightNode() != null) {  //�ݹ�����Һ���
	      theFirstTraversal(root.getRightNode());
	    }
	  }
	  public void theInOrderTraversal(Node root) {  //�������
	    if (root.getLeftNode() != null) {
	      theInOrderTraversal(root.getLeftNode());
	    }
	    printNode(root);
	    if (root.getRightNode() != null) {
	      theInOrderTraversal(root.getRightNode());
	    }
	  }
	  public void thePostOrderTraversal(Node root) {  //�������
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
	     * �f�w
	     */
	    /*System.out.println("�������");
	    tree.theFirstTraversal(root);
	    System.out.println("");
	    System.out.println("�������");
	    tree.theInOrderTraversal(root);
	    System.out.println("");
	    System.out.println("�������");
	    tree.thePostOrderTraversal(root);
	    System.out.println("");*/
	    
	    
	    /***
	     * ���f�w
	     */
	    System.out.println("�������");
	    tree.theFirstTraversal_Stack(root);
	    System.out.println("");
	    
	    System.out.println("�������");
	    tree.theInOrderTraversal_Stack(root);
	    System.out.println("");
	    
	    System.out.println("�������");
	    tree.thePostOrderTraversal_Stack(root);
	    System.out.println("");
	  }
	  
	  
	  
	  
	//===============���÷ǵݹ鷽ʽ========================
	  
	  public void theFirstTraversal_Stack(Node root) {  //�������
	    Stack<Node> stack = new Stack<Node>();
	    Node node = root;
	    while (node != null || stack.size() > 0) {  //����������ѹջ
	      if (node != null) {   //ѹջ֮ǰ�ȷ���
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
	   * �����v
	   * @param root
	   */
	  public void theInOrderTraversal_Stack(Node root) {  //�������
	    Stack<Node> stack = new Stack<Node>();
	    Node node = root;
	    while (node != null || stack.size() > 0) {
	      if (node != null) {
	        stack.push(node);   //ֱ��ѹջ
	        node = node.getLeftNode();
	      } else {
	        node = stack.pop(); //��ջ������
	        printNode(node);
	        node = node.getRightNode();
	      }
	    }
	  }
	  
	  public void thePostOrderTraversal_Stack(Node root) {   //�������
	    Stack<Node> stack = new Stack<Node>();
	    Stack<Node> output = new Stack<Node>();//����һ���м�ջ���洢���������Ľ��
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