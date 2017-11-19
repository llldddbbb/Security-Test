package com.ldb.core.validate.core;


import org.springframework.security.core.AuthenticationException;

/**
 * @author Bobbi
 * @date 2017/11/19
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String explanation) {
        super(explanation);
    }
}
