package com.csp.app.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/6/23
 */
@Service
public class ExtendEsService extends EsService {

    @Override
    public String query() throws IOException {
        return "extend";
    }

    @Override
    public void add() {

    }
}
