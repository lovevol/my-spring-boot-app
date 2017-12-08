package com.example.myspringbootapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2017-12-2
 * Time: 15:21
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MySpringBootAppApplication.class);
    }
}
