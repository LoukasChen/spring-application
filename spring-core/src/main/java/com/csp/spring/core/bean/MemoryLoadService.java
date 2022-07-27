package com.csp.spring.core.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: csp52872
 * @date: 2022/4/30
 */
@Service
@Slf4j
public class MemoryLoadService implements LoadService {

    @Override
    public void load() {
      log.info("MemoryLoadService load...");
    }

}
