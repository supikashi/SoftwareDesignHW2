package org.example.domain.exceptions;

public class TransferException extends RuntimeException {
    public TransferException(String message) {
        super(message);
    }
}
