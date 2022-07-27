package com.csp.application;

import com.csp.application.designPattern.strategy.enums.ActivityEnum;
import com.csp.application.designPattern.strategy.service.ActivityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/9/20
 */
@SpringBootTest
public class ActivityTest {

    @Autowired
    private ActivityService activityService;

    @Test
    public void test() {
        activityService.save(ActivityEnum.lottery);
    }
}
