package com.ldb.core.properties;

/**
 * @author Bobbi
 * @date 2017/11/18
 */
public class BrowserProperties {

    private String loginPage="/signIn.html";

    private LoginType loginType=LoginType.JSON;

    private int rememberMeSeconds=3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
