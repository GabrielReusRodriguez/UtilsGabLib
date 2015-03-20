package utilsGabLib.log.impl;

import utilsGabLib.log.interfaces.LogInterface;

public class LoggerFactory {

	public static LogInterface getLogger(Class clase){
		return  new Log4jWrapper(clase);
	}
	
	public static LogInterface getLogger(String name){
		return  new Log4jWrapper(name);
	}
	

}
