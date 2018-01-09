package com.vacation.app.config;

import java.nio.charset.StandardCharsets;
import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	@Value("${lang.default.lang}")
    private String defLang;

    @Value("${lang.default.locale}")
    private String defLocal;
    
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /*
     * locale change interceptor
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    /*
     * sets default locale
     */
    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        Locale defautLocal = new Locale(defLang + "_"  + defLocal);
        localeResolver.setDefaultLocale(defautLocal);
        return localeResolver;
    }

    /**
     *  message internationalization
     * @return
     */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // set *.properties file default encoding
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasename("classpath:i18n/messages");
        return messageSource;
    }
    
    
    /**
     * validation internationalization 
     * @return
     */
    @Bean
    public LocalValidatorFactoryBean validator() {
    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    	messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasename("classpath:i18n/messages");
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }
    
    @Override
    public Validator getValidator()
    {
        return validator();
    }
    
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	// Top pages
        registry.addViewController("/top").setViewName("top");
        // Apply pages
        registry.addViewController("/A0010").setViewName("apply/A0010");
        registry.addViewController("/A0100").setViewName("apply/A0100");
        registry.addViewController("/A1000").setViewName("apply/A1000");
        registry.addViewController("/A1100").setViewName("apply/A1100");
        // Approve pages
        registry.addViewController("/B1000").setViewName("approve/B1000");
        registry.addViewController("/B1100").setViewName("approve/B1100");
        registry.addViewController("/B2000").setViewName("approve/B2000");
        // Manager pages
        registry.addViewController("/C0010").setViewName("manager/C0010");
        registry.addViewController("/C1000").setViewName("manager/C1000");
        registry.addViewController("/C1100").setViewName("manager/C1100");
        registry.addViewController("/C2000").setViewName("manager/C2000");
        registry.addViewController("/C3000").setViewName("manager/C3000");
        
    }
}
