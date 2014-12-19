package me.aaa.qstns.acceptance;

import cucumber.api.java.Before;
import me.aaa.qstns.Application;
import org.springframework.boot.SpringApplication;

/**
 * Created by aaa on 19/12/14.
 */
public class SpringsDefs {
    @Before("@spring-start")
    public void before() {
        SpringApplication.run(Application.class, new String[]{});
    }
}
