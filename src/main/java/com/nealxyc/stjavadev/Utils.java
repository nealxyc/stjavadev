package com.nealxyc.stjavadev;

public class Utils {

	public static <T> T notNull(T t){
		if(t == null){
			throw new NullPointerException();
		}
		return t ;
	}
}
