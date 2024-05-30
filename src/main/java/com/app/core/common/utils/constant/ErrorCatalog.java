package com.app.core.common.utils.constant;

public enum ErrorCatalog {
    SCH_NOT_FOUND("ERR_SCHEDULE_001", "Schedule not found"),
    INVALID_SCH("ERR_SCHEDULE_002", "Invalid Schedule parameters"),
    GENERIC_ERROR("ERR_GENERIC_001", "An unexpected error occurred"),
    INVALID_TOKEN("ERR_INVALID_TOKEN_001", "Invalid token"),
    INVALID_CREDENTIALS("ERR_INVALID_CREDENTIALS_001", "Invalid Credentials(username and password required)"),
    CLIENT_NOT_FOUND("ERR_CLIENT_001", "Client not found"),;


    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
