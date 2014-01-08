package com.nealxyc.plugintest.javapythonbridge;

import java.util.Properties;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class ServerFactory {
	
	private PyObject buildingClass;
	
	public ServerFactory() {
		
        PythonInterpreter pi = new PythonInterpreter();
        pi.exec("import sys");
		
		pi.exec("sys.path.append('G:\\Workspace 2\\com.nealxyc.plugintest\\src\\main\\python')");
        pi.exec("from server_adapter import ServerAdapter");
        buildingClass = pi.get("ServerAdapter");
    }
	
	public ServerAdapter create() {

        PyObject buildingObject = buildingClass.__call__();
        return (ServerAdapter)buildingObject.__tojava__(ServerAdapter.class);
    }
}
