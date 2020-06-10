package com.gary.student_management.constants;

public enum StudentEnum {
    SUCCESS(200, "success"),
    ERROR(400, "error"),
    NOT_FOUND(404, "result not found"),
    MIN_AGE_ERROR(-6, "Min age for school is 6."),
    MAX_AGE_ERROR(-13, "Max age for school is 13"),
    SYS_ERROR(-100, "system error"),
    REQUEST_ERROR(-404, "request url error"),
    DELETE_SUCCESS(200, "delete success"),
    DELETE_FAIL(200, "delete fail"),
    TEST_ERROR(4000, "test error"),
    ;
    private Integer code;
    private String message;

    StudentEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
