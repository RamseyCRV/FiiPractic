package com.robert.bankTr.miscellaneous;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Could not find employee");
    }
}
