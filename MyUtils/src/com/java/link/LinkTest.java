package com.java.link;

import java.util.LinkedList;
import java.util.Stack;

public class LinkTest {
	
	public static void main(String[] args){
        // TODO Auto-generated method stub
        LinkedList<Integer> ll=new LinkedList<Integer>();
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<10;i++){
            ll.add(i);
        }
        System.out.print("01 >>  : ");
        for(int i:ll){
        	System.out.print(i);
            s.push(i);
        }
        ll.clear();
        while(!s.empty()){
            ll.add(s.pop());
        }
        System.out.println();
        //下面是输出,可以不要
        System.out.print("02 >>  : ");
        for(int i:ll){
            System.out.print(i);
        }
    }

}
