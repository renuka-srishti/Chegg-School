package com.chegg.school.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(Long userId) {
        super(String.format("user does not exist with id: %d", userId));
    }
}
