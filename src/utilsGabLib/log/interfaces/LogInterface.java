package utilsGabLib.log.interfaces;


public interface LogInterface {
	
	public void debug(String text);

	public void debug(String text, Throwable exception);

	public void error(String text);

	public void error(String text, Throwable exception);

	public void fatal(String text);

	public void fatal(String text, Throwable exception);

	public void trace(String text);

	public void trace(String text, Throwable exception);

	public void warn(String text);

	public void warn(String text, Throwable exception);

	public void info(String text);

	public void info(String text, Throwable exception);

	public boolean isDebugEnabled();

	public boolean isInfoEnabled();

	public boolean isTraceEnabled();

//TODO: pendiente
	//public LEVELS getLevel();


}
