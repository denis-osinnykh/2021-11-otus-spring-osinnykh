package my.spring;

import my.spring.domain.Question;
import my.spring.service.QuestionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService question = context.getBean(QuestionService.class);

        List<Question> list = question.getQuestionList();
    }
}
