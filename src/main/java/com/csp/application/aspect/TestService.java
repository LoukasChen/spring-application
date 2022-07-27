package com.csp.application.aspect;

import com.csp.application.annotation.MockService;
import com.csp.application.entity.User;
import com.csp.application.service.enableRetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: csp
 * @date: 2019/11/14
 */
@Slf4j
@Service
public class TestService {

    @Autowired
    private enableRetryService retryService;


    @MockService
    public User get(User user) {
        User users = new User();
        users.setMessage(user.getMessage() + "1");
        users.setCodeId(user.getCodeId());
        users.setRequestId(user.getRequestId());
        return users;
    }

    public User post(User user) {
        user.setMessage("post");
        return user;
    }

    public String last() throws Exception {
        try {
            return retryService.testRetry();
        } catch (Exception e) {
            log.error("retryService.testRetry error",e);
            return null;
        }
    }

    public void query() {

    }


}
