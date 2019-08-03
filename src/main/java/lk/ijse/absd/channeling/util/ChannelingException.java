package lk.ijse.absd.channeling.util;

public class ChannelingException extends RuntimeException {

    private String code;
    private String message;

    public ChannelingException() {
    }

    public ChannelingException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ChannelingException(String message, String code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public ChannelingException(String message, Throwable cause, String code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public ChannelingException(Throwable cause, String code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public ChannelingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
