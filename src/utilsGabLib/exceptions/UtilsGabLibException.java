/**
 * 
 */
package utilsGabLib.exceptions;

/**
 * @author gabriel
 *
 */
public class UtilsGabLibException extends Exception {

	private Exception exception;
	/**
	 * 
	 */
	public UtilsGabLibException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public UtilsGabLibException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public UtilsGabLibException(String message,Exception e) {
		super(message);
		this.exception= e;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public UtilsGabLibException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UtilsGabLibException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UtilsGabLibException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	
	public Exception getException(){
		return this.exception;
	}
}
