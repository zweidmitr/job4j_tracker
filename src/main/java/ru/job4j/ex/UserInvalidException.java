package ru.job4j.ex;

public class UserInvalidException extends USerNotFoundException {
    public UserInvalidException(String message) {
        super(message);
    }
}
