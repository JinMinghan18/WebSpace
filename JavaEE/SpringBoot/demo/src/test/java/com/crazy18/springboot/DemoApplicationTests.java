package com.crazy18.springboot;

import com.crazy18.springboot.bean.person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    com.crazy18.springboot.bean.person person;

    @Test
    void contextLoads() {
        System.out.println("hello world");
        System.out.println(person);

    }

}
