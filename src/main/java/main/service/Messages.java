package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Messages
{
    private ResourceBundleMessageSource messageSource;

    @Value("${spring.mvc.locale}")
    private String localeFromProperties;

    @Autowired
    public Messages(ResourceBundleMessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    public String getMessage(String id)
    {
        Locale locale = new Locale(localeFromProperties);
        return messageSource.getMessage(id, null, locale);
    }

    public String getMessage(String id, Object... param)
    {
        Locale locale = new Locale(localeFromProperties);
        return messageSource.getMessage(id, param, locale);
    }
}
