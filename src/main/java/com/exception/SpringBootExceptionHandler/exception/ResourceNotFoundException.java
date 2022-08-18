package com.exception.SpringBootExceptionHandler.exception;

public class ResourceNotFoundException extends Exception{

  String errorMessage="Resource Not Found....";
  public ResourceNotFoundException(){
    super();
  }
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
