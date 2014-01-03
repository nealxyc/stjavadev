package com.nealxyc.plugintest;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class App implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Hello world!!");
		PrintProjectInfo.main();
		return EXIT_OK;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}
