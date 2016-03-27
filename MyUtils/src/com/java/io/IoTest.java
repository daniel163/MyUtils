package com.java.io;

import java.util.Arrays;

public class IoTest {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		String info = IoUtils.readSrcFile("F:\\log_network.txt");
		System.out.println(info);
		
		boolean info1 = IoUtils.writeText("F:\\a.txt", true, "写入文件内容测试...");
		System.out.println(info1);
		
		byte[] byteinfo = IoUtils.readBinaryToByte("F:\\a.txt");
		System.out.println(Arrays.toString(byteinfo));
		
		
		byte[] bytesz = new byte[]{-48, -76, -56, -21, -50, -60, -68, -2, -60, -38, -56, -35, -78, -30, -54, -44};
		IoUtils.writeByteToBinary("F:\\a.txt", bytesz, false);
		
		Person per = new Person("zhangheng", "男", 29, "广东深圳", "13670128472");
		IoUtils.writeObject("F:\\a.txt", per, false);
		
		
		IoUtils.writeObjectArray("F:\\a.txt",new Person[]{new Person("zhangheng", "男", 29, "广东深圳", "13670128472")}, false);
		
	}

}
