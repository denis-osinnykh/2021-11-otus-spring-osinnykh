package my.spring.config;

import my.spring.dao.QuestionDao;
import my.spring.dao.QuestionDaoSimple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public QuestionDao questionDao() { return new QuestionDaoSimple("questions.csv"); }
}
