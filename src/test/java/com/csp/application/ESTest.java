package com.csp.application;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: csp
 * @date: 2020/09/06
 */
public class ESTest {

    @Test
    public void test() {
        RestClient.builder(new HttpHost("",9200,"http"));
    }
}
