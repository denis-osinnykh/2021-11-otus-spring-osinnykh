package my.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
}
