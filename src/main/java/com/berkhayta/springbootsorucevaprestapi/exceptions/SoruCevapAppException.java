package com.berkhayta.springbootsorucevaprestapi.exceptions;

import lombok.Getter;


@Getter


public class SoruCevapAppException extends RuntimeException
{
    private ErrorType errorType;

    public SoruCevapAppException(ErrorType errorType)
    {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public SoruCevapAppException(ErrorType errorType, String customMessage)
    {
        super(customMessage);
        this.errorType = errorType;
    }
}
