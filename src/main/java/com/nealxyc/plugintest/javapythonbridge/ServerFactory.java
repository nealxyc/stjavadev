package com.nealxyc.plugintest.javapythonbridge;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class ServerFactory {

	private PyObject buildingClass;
	
	public ServerFactory() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("from server_adapter import ServerAdapter");
        buildingClass = interpreter.get("ServerAdapter");
    }
	
	public ServerAdapter create() {

        PyObject buildingObject = buildingClass.__call__();
        return (ServerAdapter)buildingObject.__tojava__(ServerAdapter.class);
    }
}
