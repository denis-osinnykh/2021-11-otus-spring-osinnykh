package my.spring.config;

import my.spring.dao.QuestionDao;
import my.spring.dao.QuestionDaoSimple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

@PropertySource("classpath:config.properties")
@Configuration
public class DaoConfig {

    @Bean
    public QuestionDao questionDao(@Value("${filename}") String filename) { return new QuestionDaoSimple(filename); }
}
