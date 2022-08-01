package com.csp.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

/**
 * @description:
 * @author: csp
 * @date: 2019/11/14
 */
public class User {
    @JsonProperty("code_idewq")
    private String codeId;
    private String message;
    private String requestId;
    private String name;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("codeId='" + codeId + "'")
                .add("message='" + message + "'")
                .add("requestId='" + requestId + "'")
                .add("name='" + name + "'")
                .toString();
    }
}
