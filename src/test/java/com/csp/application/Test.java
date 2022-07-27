package com.csp.application;

import com.csp.application.circular.First;
import com.csp.application.circular.Last;
import com.csp.application.circular.Second;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/02/08
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        First first = new First();
        Second second = new Second();
        first.setSecond(second);
        Last last = new Last();
        second.setLast(last);
        last.setFirst(first);
        System.out.println();
    }

}
