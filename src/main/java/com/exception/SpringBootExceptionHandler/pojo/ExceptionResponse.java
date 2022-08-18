package com.exception.SpringBootExceptionHandler.pojo;

public class ExceptionResponse {

  private String errorMessage;

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getRequestedURI() {
    return requestedURI;
  }

  public void setRequestedURI(String requestedURI) {
    this.requestedURI = requestedURI;
  }

  private String requestedURI;


}
