package my.spring;

import my.spring.service.QuestionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableCaching
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(Main.class, args);
//        QuestionService questionBean = context.getBean(QuestionService.class);
//        questionBean.runTest();

        SpringApplication.run(Main.class, args);
    }
}
