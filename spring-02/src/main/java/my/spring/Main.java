package my.spring;

import my.spring.service.QuestionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuestionService questionBean = context.getBean(QuestionService.class);

        questionBean.printQuestionList();
    }
}
