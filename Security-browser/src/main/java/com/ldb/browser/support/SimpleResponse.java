package com.ldb.browser.support;

/**
 * @author Bobbi
 * @date 2017/11/18
 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse() {
    }

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
