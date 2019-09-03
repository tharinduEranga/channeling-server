package lk.ijse.absd.channeling.util;

public class ChannelingException extends RuntimeException {

    private int code;
    private String message;

    public ChannelingException() {
    }

    public ChannelingException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ChannelingException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public ChannelingException(String message, Throwable cause, int code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public ChannelingException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public ChannelingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
