package com.pactera.util;

import java.util.stream.IntStream;

public class ByteToBit {

	/** 
	 * Byte转Bit 
	 */  
	public static String byteToBit(byte b) {  
	   /* return "" +(byte)((b >> 7) & 0x1) +   
	    (byte)((b >> 6) & 0x1) +   
	    (byte)((b >> 5) & 0x1) +   
	    (byte)((b >> 4) & 0x1) +   
	    (byte)((b >> 3) & 0x1) +   
	    (byte)((b >> 2) & 0x1) +   
	    (byte)((b >> 1) & 0x1) +   
	    (byte)((b >> 0) & 0x1);*/
		String str="";
		for (int i=7;i>=0;i--) {
			str+=(byte)((b >> i) & 0x1);
		}
		return str;
	    
	    //b >> 7 将原第8位的bit值移到了第1位上，& 0x1的作用是只保留第一位的值，其余7位与0与将为0
	}  
	/** 
	 * Integer转Bit 
	 */  
	public static String intToBit(int b) {
		//IntStream.range(0, 31)
		String str="";
		for (int i=31;i>=0;i--) {
			str+=(byte)((b >> i) & 0x1);
		}
		
		return str;
	    
	    //b >> 7 将原第8位的bit值移到了第1位上，& 0x1的作用是只保留第一位的值，其余7位与0与将为0
	}
	
	/** 
	 * Bit转Byte 
	 */  
	public static byte BitToByte(String byteStr) {  
	    int re, len;  
	    if (null == byteStr) {  
	        return 0;  
	    }  
	    len = byteStr.length();  
	    if (len != 4 && len != 8) {  
	        return 0;  
	    }  
	    if (len == 8) {// 8 bit处理  
	        if (byteStr.charAt(0) == '0') {// 正数  
	            re = Integer.parseInt(byteStr, 2);  
	        } else {// 负数  
	            re = Integer.parseInt(byteStr, 2) - 256;  
	        }  
	    } else {//4 bit处理  
	        re = Integer.parseInt(byteStr, 2);  
	    }  
	    return (byte) re;  
	}  
	public static void main(String[] args) {
		byte b=3;
		System.out.println(ByteToBit.byteToBit(b));//00000001
		int b1=3;
		System.out.println(intToBit(b1));

	}
}
