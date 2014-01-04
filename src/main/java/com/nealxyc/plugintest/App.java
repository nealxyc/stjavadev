package com.nealxyc.plugintest;

import java.util.Properties;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.python.util.PythonInterpreter;

import com.nealxyc.plugintest.javapythonbridge.ServerAdapter;
import com.nealxyc.plugintest.javapythonbridge.ServerFactory;

public class App implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		Properties props = new Properties();
		props.setProperty("python.path", "src/main/python");
		PythonInterpreter.initialize(System.getProperties(), props, new String[] {""});
		System.out.println("Starting Salute Server ...");
		ServerAdapter sa = new ServerFactory().create();
		sa.run();
//		PrintProjectInfo.main();
		return EXIT_OK;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}
