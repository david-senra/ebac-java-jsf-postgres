package exceptions;


public class SemEstoqueException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4647660377309963940L;

	public SemEstoqueException(String msg) {
        super(msg);
    }
}
