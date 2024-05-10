package SemanticExceptions;

/**
 * An exception class for invalid ISBN-13 format.
 * This exception is thrown when an ISBN-13 in a book record fails validation.
 */
public class BadIsbn13Exception extends Exception{

    public BadIsbn13Exception() {
        super();
    }
}
