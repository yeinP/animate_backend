package org.yeinp.animate.animate_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "org.yeinp.animate.animate_backend.dao")
public class AnimateBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimateBackendApplication.class, args);
    }

}
