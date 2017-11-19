package com.ldb.code;

import com.ldb.core.validate.core.ImageCode;
import com.ldb.core.validate.core.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Bobbi
 * @date 2017/11/19
 */
@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) throws ServletRequestBindingException {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
