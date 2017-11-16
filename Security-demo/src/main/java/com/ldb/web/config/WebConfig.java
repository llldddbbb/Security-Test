package com.ldb.web.config;

import com.ldb.web.filter.TimeFilter;
import com.ldb.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bobbi
 * @date 2017/11/14
 */
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{

    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor);
    }

    /**
     * 非注解方式注册filter
     * @return
     */
//    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        TimeFilter timeFilter=new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urlList=new ArrayList<>();
        urlList.add("/*");
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }
}
