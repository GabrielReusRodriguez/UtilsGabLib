package utilsGabLib.log.impl;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import utilsGabLib.log.interfaces.LogInterface;



public class Log4jWrapper implements LogInterface{

	private Logger registro;

	protected Log4jWrapper(String name) {
		init(name);
	}

	protected Log4jWrapper(Class clase) {
		init(clase);
	}
	

	
	private void init(String name) {
		try {
		
			registro = LogManager.getLogger(name);
		} catch (Exception e) {
		System.out.println("Excepción al inicializar el log: "
					+ e.toString());
		}

	}

	private void init(Class clase) {
		try {
			registro = LogManager.getLogger(clase);
		} catch (Exception e) {
			System.out.println("Excepción al inicializar el log: "
					+ e.toString());
		}

	}

	public void debug(String text) {
		registro.debug(text);
	}

	public void debug(String text,Throwable exception){
		registro.debug(text, exception);
	}

	public void error(String text) {
		registro.error(text);
	}

	public void error(String text,Throwable exception){
		registro.error(text, exception);
	}

	public void fatal(String text){
		registro.fatal(text);		
	}

	public void fatal(String text,Throwable exception){
		registro.fatal(text, exception);
	}

	public void trace(String text) {
		registro.trace(text);
	}

	public void trace(String text,Throwable exception){
		registro.trace(text, exception);
	}

	public void warn(String text){
		registro.warn(text);
	}

	public void warn(String text,Throwable exception){
		registro.warn(text, exception);
	}

	public void info(String text){
		registro.info(text);
	}

	public void info(String text,Throwable exception){
		registro.info(text, exception);
	}

	public boolean isDebugEnabled(){
		return registro.isDebugEnabled();
	}

	public boolean isInfoEnabled(){
		return registro.isInfoEnabled();
	}

	public boolean isTraceEnabled(){
		return registro.isTraceEnabled();
	}
//TODO:Pendiente
	/*
	public LEVELS getLevel() {
		Level level = registro.getLevel();
		
		
		StandardLevel stdLevel = level.getStandardLevel();// getSyslogEquivalent();
		
		
		LEVELS returnLevel = LEVELS.UNKNOWN;
		switch (stdLevel) {
		case INFO:
			returnLevel = LEVELS.INFO;
			break;
		case DEBUG:
			returnLevel = LEVELS.DEBUG;
			break;
		case WARN:
			returnLevel = LEVELS.WARNING;
			break;
		case TRACE:
			returnLevel = LEVELS.TRACE;
			break;
		case ERROR:
			returnLevel = LEVELS.ERROR;
			break;
		case FATAL:
			returnLevel = LEVELS.FATAL;
			break;
		case ALL:
			returnLevel = LEVELS.ALL;
			break;
		case OFF:
			returnLevel = LEVELS.OFF;
			break;

		}
		

		return returnLevel;
	}
	*/

}
