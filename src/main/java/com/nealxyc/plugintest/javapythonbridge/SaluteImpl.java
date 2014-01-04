package com.nealxyc.plugintest.javapythonbridge;

public class SaluteImpl implements ISalute {

	@Override
	public String sayHi(String name) {
		salute(name);
		return "Done.";
	}

	public void salute(String name) {
		System.out.println("Hi " + name);
	}

}
