package com.ldb.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Bobbi
 * @date 2017/11/18
 */
@ConfigurationProperties(prefix = "com.ldb")
public class SecurityProperties {

    private BrowserProperties browser=new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
