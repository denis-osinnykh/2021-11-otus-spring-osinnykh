package my.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

@ConfigurationProperties(prefix = "input-output")
@Component
public class InputOutputService {
    private String locale;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Autowired
    private MessageSource messageSource;

    public String getOutputString(String key, Object[] params) {
        Locale locale = new Locale("ru", "RU");
        if (this.locale != "")
            locale = new Locale(this.locale.substring(0,2), this.locale.substring(3,5));

        return messageSource.getMessage(key, params, locale);
    }

    public void printString(String key, Object[] params) {
        System.out.println(getOutputString(key, params));
    }

    public String readString(String key, Object[] params) {
        printString(key, params);

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        else return "";
    }
}
