package lk.ijse.absd.channeling.dto.util;

public class CommonResponse<T> {
    private boolean success;
    private T body;
    private String message;

    public CommonResponse() {
    }

    public CommonResponse(boolean success, T body) {
        this.success = success;
        this.body = body;
    }

    public CommonResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CommonResponse(boolean success, T body, String message) {
        this.success = success;
        this.body = body;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
