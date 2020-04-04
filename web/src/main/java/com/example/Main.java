package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author gaoyang
 * @email 785175323@qq.com
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        JooqAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class).run(args);
    }
}
