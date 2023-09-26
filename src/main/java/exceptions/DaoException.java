
package exceptions;


public class DaoException extends Exception {
	private static final long serialVersionUID = 12964293249L;

	public DaoException(String msg, Exception ex) {
        super(msg, ex);
    }
}
