package fen.fen.constant;

import lombok.Getter;

/**
 * @author chenyufeng
 */

public enum HttpCodeConstant {
    /**
     * success http request response code and message
     */
    SUCCESS(0, "Success"),
    /**
     * fail http request response code and message
     */
    FAIL(-1, "Failed"),
    /**
     * unauthorized http request response code and message
     */
    UNAUTHORIZED(1, "Unauthorized"),
    /**
     * http request with internal error response code and message
     */
    INTERNAL_ERROR(5, "Error");

    @Getter
    private final int code;
    @Getter
    private final String msg;

    HttpCodeConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
