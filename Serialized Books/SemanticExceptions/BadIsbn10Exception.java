package SemanticExceptions;

/**
 * An exception class for invalid ISBN-10 format.
 * This exception is thrown when an ISBN-10 in a book record fails validation.
 */
public class BadIsbn10Exception extends Exception {

    public BadIsbn10Exception() {
        super();
    }
}
