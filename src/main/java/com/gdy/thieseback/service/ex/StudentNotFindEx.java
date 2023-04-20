package com.gdy.thieseback.service.ex;

public class StudentNotFindEx extends ServiceException {
    public StudentNotFindEx() {
        super();
    }

    public StudentNotFindEx(String message) {
        super(message);
    }

    public StudentNotFindEx(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFindEx(Throwable cause) {
        super(cause);
    }

    protected StudentNotFindEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
