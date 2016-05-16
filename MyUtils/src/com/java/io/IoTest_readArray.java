package com.java.io;


public class IoTest_readArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer length = IoUtils.writeObjectArray("D:\\a.txt",new Person[]{
				new Person("zhangheng1", "男", 29, "广东深圳", "13670128472"),
				new Person("zhangheng2", "男", 29, "广东深圳", "13670128472"),
				new Person("zhangheng3", "男", 29, "广东深圳", "13670128472"),
				new Person("zhangheng4", "男", 29, "广东深圳", "13670128472"),
				new Person("zhangheng5", "男", 29, "广东深圳", "13670128472"),
				new Person("zhangheng6", "男", 29, "广东深圳", "13670128472")}, false);
		
		Object[] obj = IoUtils.readArray("D:\\a.txt",length);
		for (Object object : obj) {
			System.out.println(object.toString());
		}
		
	}

}
