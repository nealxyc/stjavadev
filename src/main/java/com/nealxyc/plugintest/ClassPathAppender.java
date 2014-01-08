package com.nealxyc.plugintest;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


public class ClassPathAppender {
	
	public static void main(String[] args){
		try {
			addPath("C:\\src");
//			System.out.println(System.getProperty("java.class.path"));
//			System.setP
//			String fileSep = System.getProperty("file.separator");
//			String pathSep = System.getProperty("path.separator");
//			String classPath = System.getProperty("java.class.path");
//			classPath += pathSep + "C:" + fileSep + "src";
			printClassPath();
//			TestPrint.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void addPath(String s) throws Exception {
	    File f = new File(s);
//	    URL u = new URL(s);
	    URL u = f.toURL();
	    URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
	    Class urlClass = URLClassLoader.class;
	    Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
	    method.setAccessible(true);
	    method.invoke(urlClassLoader, new Object[]{u});
	    
	}
	
	public static void printClassPath(){
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		
		while(cl != null){
			URL[] urls = ((URLClassLoader)cl).getURLs();
	        for(URL url: urls){
	        	System.out.println(url.getFile());
	        }
	        cl = cl.getParent() ;
		}
	}
}
