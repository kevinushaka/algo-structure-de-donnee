package correction.lab5;

/**
 * A class exception for full heap
 */
@SuppressWarnings("serial")
public class FullHeapException extends Exception {

    public FullHeapException() {
        super();
    }
    public FullHeapException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}