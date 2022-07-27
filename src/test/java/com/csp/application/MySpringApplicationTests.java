package com.csp.application;

import com.csp.application.service.TestService;
import com.csp.application.entity.User;
import com.csp.application.service.ESTestService;
import com.csp.application.service.EsService;
import com.csp.application.service.ExtendEsService;
import com.csp.application.service.TransactionalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;


@SpringBootTest
class MySpringApplicationTests {

    @Autowired
    private EsService esService;

    @Autowired
    private ExtendEsService extendEsService;
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransactionalService transactionalService;

//    @Test
//    void contextLoads() {
//        try {
//            String result = testService.last();
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        Assert.isNull(testService,"注入bean成功");
//    }
//
//    @Test
//    public void jdbcTemplate_test() {
//        String sql = "select codeId,message,requestId from user";
//        List<User> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
//            User user = new User();
//            user.setCodeId(rs.getString("codeId"));
//            user.setMessage(rs.getString("message"));
//            user.setCodeId(rs.getString("requestId"));
//            return user;
//        });
//        System.out.println();
//    }
//
//    @Test
//    public void add() {
//        for (int i = 0; i < 20; i++) {
//            jdbcTemplate.update("insert into user values(" + i + "," + i + ",'csp'," + i + ")");
//        }
//    }

    @Test
    public void transactionTest() throws Exception {
        transactionalService.update();
//        transactionalService.add();
    }

    @Test
    public void test() throws IOException {
        System.out.println(esService);
        System.out.println(extendEsService.query());
    }

}
