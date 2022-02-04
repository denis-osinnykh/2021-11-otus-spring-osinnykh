package my.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "dao")
@Component
public class DaoConfig {

    private final String fileName = "questions.csv";

    public String getFileName() {
        return fileName;
    }

    private String language;

    public String getLanguage() { return language; }

    public void setLanguage(String language) {
        if (language != "")
            this.language = language;
        else
            this.language = "RU";
    }
}
