package com.zhou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudResttemplateApplicationTest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testRestTemplate() {
        String url = "http://localhost:18081/user/list";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }
}
