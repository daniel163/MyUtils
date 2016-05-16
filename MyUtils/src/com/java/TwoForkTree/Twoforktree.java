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
     * @param root �����ڵ� 
     * �ݹ�������� 
     */  
    public static void preOrderRec(Twoforktree root){  
        if(root!=null){  
            System.out.println(root.value);  
            preOrderRec(root.left);  
            preOrderRec(root.right);  
        }  
    }  
    /** 
     * @param root �����ڵ� 
     * �ݹ�������� 
     */  
    public static void inOrderRec(Twoforktree root){  
        if(root!=null){  
            preOrderRec(root.left);  
            System.out.println(root.value);  
            preOrderRec(root.right);  
        }  
    }  
    /** 
     * @param root �����ڵ� 
     * �ݹ������� 
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
     * @param root �����ڵ� 
     * ����ջʵ��ѭ��������������� 
     * ����ʵ��������ͼ��������ȱ�����DFS�� 
     * ά��һ��ջ�������ڵ���ջ��Ȼ��ֻҪջ��Ϊ�գ���ջ�����ʣ��������ν����ʽڵ���ҽڵ㡢��ڵ���ջ�� 
     * ���ַ�ʽӦ���Ƕ����������һ������ʵ�֣�����ȥ�����ˣ������ǲ��߱��ܺõ���չ�ԣ�������ͺ���ʽ�в����� 
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
     * @param root ���ĸ��ڵ� 
     * ����ջģ��ݹ����ʵ��ѭ��������������� 
     * ���ַ�ʽ�߱���չ�ԣ���ģ��ݹ�Ĺ��̣����������㲻�ϵ�ѹ��ջ��ֱ��null��Ȼ����ջ���ڵ�������� 
     */  
    public static void preOrderStack_2(Twoforktree root){  
        if(root==null)return;  
        Stack<Twoforktree> s=new Stack<Twoforktree>();  
        while(root!=null||!s.isEmpty()){  
            while(root!=null){  
                System.out.println(root.value);  
                s.push(root);//�ȷ�������ջ  
                root=root.left;  
            }  
            root=s.pop();  
            root=root.right;//�����null����ջ������������  
        }  
    }  
    /** 
     *  
     * @param root �����ڵ� 
     * ����ջģ��ݹ����ʵ��ѭ���������������  >>>>>>>>>>>  ****
     * ˼��������preOrderStack_2��ͬ��ֻ�Ƿ��ʵ�ʱ��������������������ֱ��null��ʱ���ջ�����ʡ� 
     */  
    public static void inOrderStack(Twoforktree root){
        if(root==null)return;  
        Stack<Twoforktree> s=new Stack<Twoforktree>();  
        while(root!=null||!s.isEmpty()){  
            while(root!=null){  
                s.push(root);//�ȷ�������ջ  
                root=root.left;  
            }  
            root=s.pop();  
            System.out.println(root.value);  
            root=root.right;//�����null����ջ������������  
        }  
    }  
    /** 
     *  
     * @param root �����ڵ� 
     * ���������ͬ���������������Ҫ�ȴ���������������Ȼ���ٴ�����(����)��������Ҫһ����¼��Щ�ڵ��Ѿ������ʵĽṹ(���������ṹ�����һ�����)�����������mapʵ�� 
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
     * @param root �����ڵ� 
     * ����������������ö���ʵ�֣��Ƚ����ڵ�����У�ֻҪ���в�Ϊ�գ�Ȼ������У������ʣ����Ž����ʽڵ������������������� 
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