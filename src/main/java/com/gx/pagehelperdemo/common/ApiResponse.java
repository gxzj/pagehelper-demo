package com.gx.pagehelperdemo.common;

/**
 * 定制消息返回实体
 */
public class ApiResponse {

    private int code; //状态码
    private String message; //消息
    private long size; //数据总数(分页)
    private Object data; //数据

    public ApiResponse() {
        super();
    }

    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(int code, String message, long size, Object data) {
        this.code = code;
        this.message = message;
        this.size = size;
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 定义常用方法
     * @param data
     * @return
     */
    public static ApiResponse ofSuccess(Object data){
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data);
    }

    public static ApiResponse ofSuccess(long size, Object data){
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), size, data);
    }

    public static ApiResponse ofMessage(int code, String message){
        return new ApiResponse(code, message, null);
    }

    public static ApiResponse ofStatus(Status status){
        return new ApiResponse(status.getCode(), status.getStandardMessage(), null);
    }

    /**
     * 定义状态枚举
     */
    public enum Status {
        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "page not found"),
        INTERNAL_SERVER_ERROR(500, "server internal error"),
        NOT_LOGIN(400005, "not login"),
        INVALID_PARAM(40006, "interval param");

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }

}