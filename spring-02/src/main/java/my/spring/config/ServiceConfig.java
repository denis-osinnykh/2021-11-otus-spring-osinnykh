package my.spring.config;

import my.spring.dao.QuestionDao;
import my.spring.service.QuestionService;
import my.spring.service.QuestionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:config.properties")
@Configuration
public class ServiceConfig {

    @Bean
    public QuestionService questionService(QuestionDao dao) { return new QuestionServiceImpl(dao); }
}
