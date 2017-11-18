package com.ldb.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Bobbi
 * @date 2017/11/18
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //自定义的User要实现UserDetails
        logger.info("登陆用户名："+username);
        //根据用户名查找用户信息
        //根据查找到的信息判断用户是否被冻结
        String password=passwordEncoder.encode("123456");
        logger.info("数据库密码是："+password);
        return new User(username,password,
                true,true,false,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }


}
