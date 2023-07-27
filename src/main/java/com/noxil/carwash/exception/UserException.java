package com.noxil.carwash.exception;

public class UserException extends BaseException {

    public UserException(String code) {
        super("User." + code);
    }

    public static UserException requestIsNull() {
        return new UserException("register.request.null");
    }

    public static UserException emailIsNull() {
        return new UserException("register.email.null");
    }

    public static UserException createEmailIsNull() {
        return new UserException("create.email.null");
    }

    public static UserException createUsernameIsNull() {
        return new UserException("create.username.null");
    }

    public static UserException createPasswordIsNull() {
        return new UserException("create.password.null");
    }

    public static UserException createEmailDuplicate() {
        return new UserException("create.email.duplicate");
    }

    public static UserException createUsernameDuplicate() {
        return new UserException("create.username.duplicate");
    }
}
