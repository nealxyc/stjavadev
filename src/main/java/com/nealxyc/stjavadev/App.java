package com.nealxyc.stjavadev;

import java.net.URLClassLoader;
import java.util.Properties;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.python.util.PythonInterpreter;

import com.nealxyc.plugintest.javapythonbridge.ServerAdapter;
import com.nealxyc.plugintest.javapythonbridge.ServerFactory;

public class App implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		
//		ClassPathAppender.addPath("/G:/Workspace 2/com.nealxyc.plugintest/src/main/python");
//		ClassPathAppender.printClassPath();
//		
//		
//		Properties props = new Properties();
//		props.setProperty("python.path", "G:\\Workspace 2\\com.nealxyc.plugintest\\src\\main\\python");
//		PythonInterpreter.initialize(System.getProperties(), props, new String[] {""});
		
//		PythonInterpreter pi = new PythonInterpreter();

		System.out.println("Starting Salute Server ...");
//		ServerAdapter sa = new ServerFactory().create();
//		sa.run();
		
        PythonInterpreter pi = new PythonInterpreter();
        pi.exec("import sys");//import salute_server
		
        pi.exec("sys.path.append('G:\\Workspace 2\\com.nealxyc.plugintest\\src\\main\\python')");
		pi.exec("sys.path.append('G:\\Workspace 2\\com.nealxyc.plugintest\\bin')");
		
		pi.exec("print sys.path");
		pi.exec("print sys.version_info");;
		
		pi.exec("import stjavadev_server");
        pi.exec("stjavadev_server.main()");
        
//		PrintProjectInfo.main();
		return EXIT_OK;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}
