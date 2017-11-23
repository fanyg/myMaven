package com.pactera.util;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	private static Properties p = new Properties();  
	  
    /** 
     * 读取properties配置文件信息 
     */  
    static{  
        try {  
            p.load(ReadProperties.class.getClassLoader().getResourceAsStream("jdbc.properties"));  
        } catch (IOException e) {  
            e.printStackTrace();   
        }  
    }  
    /** 
     * 根据key得到value的值 
     */  
    public static String getValue(String key)  
    {  
        return p.getProperty(key);  
    }
    public static void main(String[] args) {
    	
    	String name=ReadProperties.getValue("username");
    	System.out.println(name);
	}
}
