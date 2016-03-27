package com.java.io;

public class IoTest_readObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person per = new Person("zhangheng", "ÄÐ", 29, "¹ã¶«ÉîÛÚ", "13670128472");
		IoUtils.writeObject("F:\\a.txt", per, false);
		
		
		Person per1 = (Person)IoUtils.readObject("F:\\a.txt");
		System.out.println(per1.toString());
	}

}
