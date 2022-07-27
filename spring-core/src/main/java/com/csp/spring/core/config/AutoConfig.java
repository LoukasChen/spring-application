package com.csp.spring.core.config;

import com.csp.spring.core.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: csp52872
 * @date: 2022/5/24
 */
@Configuration
public class AutoConfig {

    @Bean
    public User user() {
        return new User() {{
            setName("auto");
        }};
    }

}
