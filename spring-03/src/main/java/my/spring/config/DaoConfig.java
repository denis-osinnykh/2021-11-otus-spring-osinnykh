package my.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "dao")
@Component
public class DaoConfig {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String language;

    public String getLanguage() {
        if (language != null)
            return language;
        else
            return "";
    }

    public void setLanguage(String language) { this.language = language;}

    //@Bean
//    public QuestionDao questionDao() {
//        return new QuestionDaoSimple(getFile());
//    }
}
