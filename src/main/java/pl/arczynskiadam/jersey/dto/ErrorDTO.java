package pl.arczynskiadam.jersey.dto;

public class ErrorDTO {
    private String errorMsg;
    private String httpStatus;

    public ErrorDTO(String errorMsg, String httpStatus) {
        this.errorMsg = errorMsg;
        this.httpStatus = httpStatus;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
}
