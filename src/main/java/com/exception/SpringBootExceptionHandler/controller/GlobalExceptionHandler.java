package com.exception.SpringBootExceptionHandler.controller;

import com.exception.SpringBootExceptionHandler.exception.ResourceNotFoundException;
import com.exception.SpringBootExceptionHandler.pojo.ExceptionResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value= HttpStatus.NOT_FOUND)
  public @ResponseBody
  ExceptionResponse handleResourceNotFoundException(final ResourceNotFoundException resourceNotFoundException,
      final HttpServletRequest httpServletRequest){

    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setErrorMessage(resourceNotFoundException.getMessage());
    exceptionResponse.setRequestedURI(httpServletRequest.getRequestURI());
    return exceptionResponse;
  }


  @ExceptionHandler(Exception.class)
  @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
  public @ResponseBody
  ExceptionResponse handleInternalServerErrprException(final Exception exception,final HttpServletRequest request){
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setErrorMessage("Internal Server Error");
    exceptionResponse.setRequestedURI(request.getRequestURI());
    return exceptionResponse;
  }
}
