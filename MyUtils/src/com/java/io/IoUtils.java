package com.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IoUtils {
	/***
	 * ��ȡָ��·���ı��ļ�
	 * @param filePath �ļ�·��
	 * @return �ļ���Ϣ
	 */
    public static String readSrcFile(String filePath) {
        StringBuilder str = new StringBuilder();  
        BufferedReader in = null;  
        try {
            in = new BufferedReader(new FileReader(filePath));  
            String s;  
            try {  
                while ((s = in.readLine()) != null)  
                    str.append(s + '\n');  
            } finally {  
                in.close();  
            }  
        } catch (IOException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return str.toString();  
    }
     
    
    /***
     * д��ָ�����ı��ļ���appendΪtrue��ʾ׷�ӣ�false��ʾ��ͷ��ʼд��  
     * text��Ҫд����ı��ַ�����textΪnullʱֱ�ӷ���  
     * @param filePath	�ļ�·��
     * @param append	true��ʾ׷��,flase��ʾ��ͷ��ʼд
     * @param text		text��ʾд���ļ����ַ��� , ���Ϊnull��ֱ�ӷ���
     */
    public static boolean writeText(String filePath, boolean append, String text) {
    	boolean identification = false;
        if (text == null)
            return identification;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath,
                    append));
            try {  
                out.write(text);
                identification = true;
            } finally {
                out.close();
            }  
        } catch (IOException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }
        
        return identification;
    }
    
    
    /***
     * �Ѷ������ļ������ֽ����飬���û�����ݣ��ֽ�����Ϊnull
     * @param filePath	�ļ�·��
     * @return			�ֽ�����
     */
    public static byte[] readBinaryToByte(String filePath) {
        byte[] data = null;  
        try {  
            BufferedInputStream in = new BufferedInputStream(
                    new FileInputStream(filePath));
            try {  
                data = new byte[in.available()];  
                in.read(data);  
            } finally {  
                in.close();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return data;  
    }  
    
    
    /***
     * ���ֽ�����Ϊд��������ļ�������Ϊnullʱֱ�ӷ���  
     * @param filePath	�ļ�·��
     * @param data		�ֽ�����
     * @param append	Ϊtrue��ʾ����ĩβд��, false��ʾ��ͷд��
     */
    public static void writeByteToBinary(String filePath, byte[] data ,boolean append) {
        if (data == null)  
            return;  
        try {  
            BufferedOutputStream out = new BufferedOutputStream(  
                    new FileOutputStream(filePath,true));  
            try {  
                out.write(data);  
            } finally {  
                out.close();
            }  
        } catch (IOException e) {
            e.printStackTrace();  
        }  
    }  
    
    
    
    /***
     * ��һ������д���ļ���isAppendΪtrue��ʾ׷�ӷ�ʽд��false��ʾ����д  
     * @param filePath	�ļ�·��
     * @param o			����
     * @param isAppend	Ϊtrue��ʾ׷�ӷ�ʽд��false��ʾ����д 
     */
    public static void writeObject(String filePath, Object o, boolean isAppend) {
        if (o == null)  
            return;  
        try {  
        	 File f = new File(filePath);
             MyObjectOutputStream out = MyObjectOutputStream.newInstance(f,  
                     new FileOutputStream(f, isAppend));
            try {  
                out.writeObject(o);  
            } finally {  
                out.close();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }   
    
    
    
    /***
     * ��һ����������д���ļ���isAppendΪtrue��ʾ׷�ӷ�ʽд��false��ʾ����д  
     * @param filePath	�ļ�·��
     * @param objects	����
     * @param isAppend	Ϊtrue��ʾ׷�ӷ�ʽд��false��ʾ����д  
     * @return ���鳤��
     */
    public static Integer writeObjectArray(String filePath, Object[] objects, boolean isAppend) {
        if (objects == null)  
            return 0;  
        try {  
        	File f = new File(filePath);
            MyObjectOutputStream out = MyObjectOutputStream.newInstance(f,  
                    new FileOutputStream(f, isAppend)); 
            try {  
                for (Object o : objects)  
                    out.writeObject(o);  
            } finally {  
                out.close();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return objects.length;
    }

    
    
    /***
     * ��ȡ���󣬷���һ������  
     * @param filePath	�ļ�·��
     * @return			�����������
     */
    public static Object readObject(String filePath) {
        Object o = null;  
        try {  
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(  
                    filePath));  
            try {  
                o = in.readObject();  
            } finally {  
                in.close();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return o;  
    }  
    
    
    
    /***
     * ��ȡ���󣬷���һ���������飬count��ʾҪ���Ķ���ĸ���
     * @param filePath	�ļ�·��
     * @param count		��ȡ�ĸ���
     * @return			��������
     */
    public static Object[] readArray(String filePath, int count) {
        Object[] objects = new Object[count];  
        try {  
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(  
                    filePath));  
            try {  
                for (int i = 0; i < count; i++) {
                    objects[i] = in.readObject();  
                }  
            } finally {  
                in.close();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return objects;  
    } 
    
}
