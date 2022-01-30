package my.spring.config;

import my.spring.dao.QuestionDao;
import my.spring.service.QuestionService;
import my.spring.service.QuestionServiceImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@ConfigurationProperties(prefix = "service")
@Component
public class ServiceConfig {

    private int requiredAnswerCount;

    public int getRequiredAnswerCount() {
        return requiredAnswerCount;
    }

    public void setRequiredAnswerCount(int requiredAnswerCount) {
        this.requiredAnswerCount = requiredAnswerCount;
    }

//    @Bean
//    public QuestionService questionService(QuestionDao dao) {
//        var service = new QuestionServiceImpl(dao);
//        service.setRequiredAnswerCount(requiredAnswerCount);
//        return service;
//    }
}
