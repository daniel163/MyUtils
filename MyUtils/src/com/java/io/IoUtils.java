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
	 * 读取指定路径文本文件
	 * @param filePath 文件路径
	 * @return 文件信息
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
     * 写入指定的文本文件，append为true表示追加，false表示重头开始写，  
     * text是要写入的文本字符串，text为null时直接返回  
     * @param filePath	文件路径
     * @param append	true表示追加,flase表示重头开始写
     * @param text		text表示写入文件的字符串 , 如果为null是直接返回
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
     * 把二进制文件读入字节数组，如果没有内容，字节数组为null
     * @param filePath	文件路径
     * @return			字节数组
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
     * 把字节数组为写入二进制文件，数组为null时直接返回  
     * @param filePath	文件路径
     * @param data		字节数组
     * @param append	为true表示接在末尾写入, false表示重头写入
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
     * 把一个对象写入文件，isAppend为true表示追加方式写，false表示重新写  
     * @param filePath	文件路径
     * @param o			对象
     * @param isAppend	为true表示追加方式写，false表示重新写 
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
     * 把一个对象数组写入文件，isAppend为true表示追加方式写，false表示重新写  
     * @param filePath	文件路径
     * @param objects	对象
     * @param isAppend	为true表示追加方式写，false表示重新写  
     * @return 数组长度
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
     * 读取对象，返回一个对象  
     * @param filePath	文件路径
     * @return			返回这个对象
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
     * 读取对象，返回一个对象数组，count表示要读的对象的个数
     * @param filePath	文件路径
     * @param count		读取的个数
     * @return			对象数组
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
