package cnav.gipur.pci.batch.exceptions;

/**
 * 
 * @author ZEX9977
 *
 */
public class BuisinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String errorMessage;

	public BuisinessException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
