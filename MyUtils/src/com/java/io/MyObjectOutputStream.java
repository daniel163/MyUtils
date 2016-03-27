package com.java.io;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {
	
	private static File f;  
	  
    // writeStreamHeader()��������ObjectOutputStream�Ĺ��췽������õ�  
    // ���ڸ��Ǻ��writeStreamHeader()�����õ���f�����ֱ���ô˹��췽������  
    // һ��MyObjectOutputStream������ôwriteStreamHeader()�е�f�ǿ�ָ��  
    // ��Ϊf��û�г�ʼ��������������õ�̬ģʽ  
    private MyObjectOutputStream(OutputStream out, File f) throws IOException,  
            SecurityException {  
        super(out);  
    }  
  
    // ����һ��MyObjectOutputStream�������ﱣ֤��new MyObjectOutputStream(out, f)  
    // ֮ǰf�Ѿ�ָ��һ��File����  
    public static MyObjectOutputStream newInstance(File file, OutputStream out)
            throws IOException {  
        f = file;// ����������Ҫ�ĵط��������ļ�������������ָ��ͬһ���ļ�����  
        return new MyObjectOutputStream(out, f);
    }  
  
    @Override  
    protected void writeStreamHeader() throws IOException {
        // �ļ������ڻ��ļ�Ϊ��,��ʱ�ǵ�һ��д���ļ�������Ҫ��ͷ����Ϣд�롣  
        if (!f.exists() || (f.exists() && f.length() == 0)) {  
            super.writeStreamHeader();  
        } 
    } 

}
