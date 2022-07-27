package com.csp.application.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @description:
 * @author: csp
 * @date: 2020/09/06
 */
@Service
public class EsService extends BaseService implements TestService, DisposableBean {

    private RestClient restClient;

    public String query() throws IOException {
        Request request = new Request(HttpPost.METHOD_NAME,"");
        String queryCondition = "{\n" +
                "  \"query\": {\n" +
                "    \"match_all\": {}\n" +
                "  }\n" +
                "}";
        request.setEntity(new NStringEntity(StringUtils.removePattern(queryCondition, "\n|\r|\t"), ContentType.APPLICATION_JSON));
        Response response = restClient.performRequest(request);
        return EntityUtils.toString(response.getEntity(), "utf8");
    }


    @Override
    public void destroy() throws Exception {
        restClient.close();
    }

    @Override
    public void add() {

    }
}
