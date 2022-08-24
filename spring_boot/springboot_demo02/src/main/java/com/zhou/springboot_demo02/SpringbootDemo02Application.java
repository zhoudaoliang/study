package com.zhou.springboot_demo02;

import com.zhou.springboot_demo02.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDemo02Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringbootDemo02Application.class, args);
        User user = (User)context.getBean("user");
        System.out.println(user);
    }

}
