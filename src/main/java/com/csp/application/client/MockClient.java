package com.csp.application.client;

import com.csp.application.mock.CommonTransformer;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

/**
 * @description:
 * @author: csp
 * @date: 2020/05/19
 */
public class MockClient {

    public void init() {
        WireMock.configureFor(8089);
        WireMock.removeAllMappings();
        WireMock.stubFor(WireMock.post(WireMock.urlPathEqualTo("/test/name"))
                .willReturn(WireMock.aResponse()
                        .withBody("{\"name\":\"csp123\"}")
                        .withStatus(200)));

        WireMock.stubFor(WireMock.post(WireMock.urlPathEqualTo("/test/age"))
                .willReturn(WireMock.aResponse()
                        .withBody("{\"age\":\"24\"}")
                        .withStatus(200)));
    }

    public static void main(String[] args) {
//        new MockClient().init();

        WireMockConfiguration configuration = new WireMockConfiguration().port(8089);
        configuration.extensions(CommonTransformer.class);
        configuration.disableRequestJournal();
        WireMockServer server = new WireMockServer(configuration);
        server.stubFor(WireMock.post(WireMock.urlMatching("/.*?")));
        server.start();
    }
}
