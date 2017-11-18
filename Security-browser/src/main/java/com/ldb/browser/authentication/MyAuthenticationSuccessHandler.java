package com.ldb.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ldb.core.properties.LoginType;
import com.ldb.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Bobbi
 * @date 2017/11/18
 */
@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    //登陆成功后会被调用
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("登陆成功");
        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else{
            super.onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);
        }
    }
}
