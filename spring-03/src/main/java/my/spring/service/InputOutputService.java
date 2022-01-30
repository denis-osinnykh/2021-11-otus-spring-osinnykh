package my.spring.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

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

    public void outputString(String key, Object[] params) {
        Locale locale = new Locale("ru", "RU"); //Locale.getDefault();
        if (this.locale != null)
            locale = new Locale(this.locale.substring(0,2), this.locale.substring(3,5));
        //ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        //String str = bundle.getString(key);

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("messages");
        System.out.println(messageSource.getMessage(key, params, locale));

        //System.out.println(str);

    }
}
