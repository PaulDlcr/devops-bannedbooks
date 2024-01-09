package org.grostarin.springboot.demorest.exceptions;

public class BookInBannedBooksException extends RuntimeException {
    public BookInBannedBooksException() {
        super();
    }

    public BookInBannedBooksException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BookInBannedBooksException(final String message) {
        super(message);
    }

    public BookInBannedBooksException(final Throwable cause) {
        super(cause);
    }
}
