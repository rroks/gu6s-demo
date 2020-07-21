package fen.fen.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chenyufeng
 */
public class RestResponse<T> {
    @JsonProperty
    private int code;
    @JsonProperty("msg")
    private String message;
    @JsonProperty
    private T data;

    public RestResponse() {
    }

    public RestResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
