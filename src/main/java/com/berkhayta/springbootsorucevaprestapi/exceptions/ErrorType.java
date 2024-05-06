package com.berkhayta.springbootsorucevaprestapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType
{
  QUESTION_NOT_FOUND(5001,"Soru bulunamadı.", HttpStatus.NOT_FOUND);

  private Integer code;
  private String message;
  private HttpStatus status;
}
