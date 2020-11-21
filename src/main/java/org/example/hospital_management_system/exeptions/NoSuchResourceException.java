package org.example.hospital_management_system.exeptions;

public class NoSuchResourceException extends RuntimeException {

    public NoSuchResourceException(String massage) {
        super(massage);
    }
}
