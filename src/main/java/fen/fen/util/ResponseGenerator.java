package fen.fen.util;


import fen.fen.constant.HttpCodeConstant;
import fen.fen.model.RestResponse;

/**
 * @author chenyufeng
 */
public class ResponseGenerator {
    private ResponseGenerator() {
    }

    public static <T> RestResponse<T> generateSuccess() {
        return generateSuccess(null);
    }

    public static <T> RestResponse<T> generateSuccess(T data) {
        return generateSuccess(data, null);
    }

    public static <T> RestResponse<T> generateSuccess(T data, String message) {
        RestResponse<T> response = new RestResponse<>();
        response.setCode(HttpCodeConstant.SUCCESS.getCode());
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static <T> RestResponse<T> generateFailure() {
        return generateFailure(null);
    }

    public static <T> RestResponse<T> generateFailure(T data) {
        return generateFailure(data, HttpCodeConstant.FAIL.getMsg());
    }

    public static <T> RestResponse<T> generateFailure(T data, String message) {
        RestResponse<T> response = new RestResponse<>();
        response.setCode(HttpCodeConstant.FAIL.getCode());
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
