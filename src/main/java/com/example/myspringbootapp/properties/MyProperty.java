package com.example.myspringbootapp.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2017-12-1
 * Time: 13:58
 */
@Component
//读取配置文件，提取其中的数据
@ConfigurationProperties(prefix = "myproperty")
public class MyProperty {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
