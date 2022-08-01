package com.csp.app.mock;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

/**
 * @description:
 * @author: csp
 * @date: 2020/05/19
 */
public class CommonTransformer extends ResponseTransformer {
    @Override
    public Response transform(Request request, Response response, FileSource fileSource, Parameters parameters) {
        WireMock.stubFor(WireMock.post(WireMock.urlPathEqualTo("/test/name"))
                .willReturn(WireMock.aResponse()
                        .withBody("{\"name\":\"csp123\"}")
                        .withStatus(200)));
        // 1.根据请求url去数据库中查找记录
//        if (request.getUrl() != null) {
//            // 2.根据入参去数据库中查询返回值
//            if (request.getBodyAsString() != null) {
//                return Response.response()
//                        .status(200)
//                        // 3.拿到数据库中查到的返回值
//                        .body("{\"name\":\"csp123\"}")
//                        .build();
//            }
//        }
//        return null;
        return null;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
