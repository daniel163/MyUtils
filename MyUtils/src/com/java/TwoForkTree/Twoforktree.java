package com.java.TwoForkTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Twoforktree {
	
	public int value;  
    public Twoforktree left;  
    public Twoforktree right;  
    
    public Twoforktree(int v){  
        this.value=v;  
        this.left=null;  
        this.right=null;  
    }  
      
}

class BinaryTreeTraversal {  
    /** 
     * @param root 树根节点 
     * 递归先序遍历 
     */  
    public static void preOrderRec(Twoforktree root){  
        if(root!=null){  
            System.out.println(root.value);  
            preOrderRec(root.left);  
            preOrderRec(root.right);  
        }  
    }  
    /** 
     * @param root 树根节点 
     * 递归中序遍历 
     */  
    public static void inOrderRec(Twoforktree root){  
        if(root!=null){  
            preOrderRec(root.left);  
            System.out.println(root.value);  
            preOrderRec(root.right);  
        }  
    }  
    /** 
     * @param root 树根节点 
     * 递归后序遍历 
     */  
    public static void postOrderRec(Twoforktree root){  
        if(root!=null){  
            preOrderRec(root.left);  
            preOrderRec(root.right);  
            System.out.println(root.value);  
        }  
    }  
    /** 
     *  
     * @param root 树根节点 
     * 利用栈实现循环先序遍历二叉树 
     * 这种实现类似于图的深度优先遍历（DFS） 
     * 维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。 
     * 这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用 
     */  
    public static void preOrderStack_1(Twoforktree root){  
        if(root==null)return;  
        Stack<Twoforktree> s=new Stack<Twoforktree>();  
        s.push(root);  
        while(!s.isEmpty()){  
        	Twoforktree temp=s.pop();  
            System.out.println(temp.value);  
            if(temp.right!=null) s.push(temp.right);  
            if(temp.left!=null) s.push(temp.left);  
        }  
    }  
    /** 
     *  
     * @param root 树的根节点 
     * 利用栈模拟递归过程实现循环先序遍历二叉树 
     * 这种方式具备扩展性，它模拟递归的过程，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树 
     */  
    public static void preOrderStack_2(Twoforktree root){  
        if(root==null)return;  
        Stack<Twoforktree> s=new Stack<Twoforktree>();  
        while(root!=null||!s.isEmpty()){  
            while(root!=null){  
                System.out.println(root.value);  
                s.push(root);//先访问再入栈  
                root=root.left;  
            }  
            root=s.pop();  
            root=root.right;//如果是null，出栈并处理右子树  
        }  
    }  
    /** 
     *  
     * @param root 树根节点 
     * 利用栈模拟递归过程实现循环中序遍历二叉树  >>>>>>>>>>>  ****
     * 思想和上面的preOrderStack_2相同，只是访问的时间是在左子树都处理完直到null的时候出栈并访问。 
     */  
    public static void inOrderStack(Twoforktree root){
        if(root==null)return;  
        Stack<Twoforktree> s=new Stack<Twoforktree>();  
        while(root!=null||!s.isEmpty()){  
            while(root!=null){  
                s.push(root);//先访问再入栈  
                root=root.left;  
            }  
            root=s.pop();  
            System.out.println(root.value);  
            root=root.right;//如果是null，出栈并处理右子树  
        }  
    }  
    /** 
     *  
     * @param root 树根节点 
     * 后序遍历不同于先序和中序，它是要先处理完左右子树，然后再处理根(回溯)，所以需要一个记录哪些节点已经被访问的结构(可以在树结构里面加一个标记)，这里可以用map实现 
     */  
    public static void postOrderStack(Twoforktree root){  
        if(root==null)return;  
        Stack<Twoforktree> s=new Stack<Twoforktree>();  
        Map<Twoforktree,Boolean> map=new HashMap<Twoforktree,Boolean>();   
        s.push(root);  
        while(!s.isEmpty()){  
        	Twoforktree temp=s.peek();  
            if(temp.left!=null&&!map.containsKey(temp.left)){  
                temp=temp.left;  
                while(temp!=null){  
                    if(map.containsKey(temp))break;  
                    else s.push(temp);  
                    temp=temp.left;  
                }  
                continue;  
            }  
            if(temp.right!=null&&!map.containsKey(temp.right)){  
                s.push(temp.right);  
                continue;  
            }  
            Twoforktree t=s.pop();  
            map.put(t,true);  
            System.out.println(t.value);  
        }  
    }  
    /** 
     *  
     * @param root 树根节点 
     * 层序遍历二叉树，用队列实现，先将根节点入队列，只要队列不为空，然后出队列，并访问，接着讲访问节点的左右子树依次入队列 
     */  
    public static void levelTravel(Twoforktree root){  
        if(root==null)return;  
        Queue<Twoforktree> q=new LinkedList<Twoforktree>();  
        q.add(root);  
        while(!q.isEmpty()){  
        	Twoforktree temp =  q.poll();  
            System.out.println(temp.value);  
            if(temp.left!=null)q.add(temp.left);  
            if(temp.right!=null)q.add(temp.right);  
        }  
    } 

}
