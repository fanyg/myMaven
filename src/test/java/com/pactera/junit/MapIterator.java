package com.pactera.junit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class MapIterator {
	public void cs() {
		Map<String,String> map=new HashMap<String,String>();
		String message="http";
		for(String str:map.keySet()) {// 1map keyset循环1
			if(message.equals(str)) {
				
			}
		}
		
		for(String str:map.values()) {//2map values 循环
			System.out.println(str);
		}
		
		Iterator<Entry<String, String>> it = map.entrySet().iterator();//3map entry循环
		while(it.hasNext()) {
			Entry<String, String> entry = it.next();
			System.out.println(entry.getKey()+entry.getValue());
		}
		
		for(Entry<String, String> entry:map.entrySet()) {//4推荐，尤其是容量大时
			System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
		}
		
	}

	
	
}
