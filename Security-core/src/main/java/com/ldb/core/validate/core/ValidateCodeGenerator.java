package com.ldb.core.validate.core;


import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Bobbi
 * @date 2017/11/19
 */
public interface ValidateCodeGenerator {

    ImageCode generate(ServletWebRequest request) throws ServletRequestBindingException;
}
