package com.java.Proxy;

public class RealSubject implements Subject {

	@Override
	public void doSomething() {
		System.out.println("call doSomething !");
	}

}
