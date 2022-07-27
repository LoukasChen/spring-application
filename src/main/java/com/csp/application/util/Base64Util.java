package com.csp.application.util;

import org.springframework.util.Base64Utils;


/**
 * @description:
 * @author: csp
 * @date: 2019/12/09
 */
public class Base64Util {

    public Base64Util() {
        System.out.println("Base64Util");
    }

    public static String encypt(String str) {
        return Base64Utils.encodeToString(str.getBytes());
    }

    public static void main(String[] args) {
        String encypt = Base64Util.encypt("tongchengjinfu:123456");
        System.out.println(encypt);
    }
}
