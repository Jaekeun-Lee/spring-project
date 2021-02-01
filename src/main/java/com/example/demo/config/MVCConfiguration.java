package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class MVCConfiguration implements WebMvcConfigurer {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {

        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();

        // 메세지 프로퍼티파일의 위치와 이름을 지정한다.
        source.setBasename("classpath:/messages/message");

        // 기본 인코딩을 지정한다.
        source.setDefaultEncoding("UTF-8");

        // 프로퍼티 파일의 변경을 감지할 시간 간격을 지정한다.
        source.setCacheSeconds(60);

        // 없는 메세지일 경우 예외를 발생시키는 대신 코드를 기본 메세지로 한다.
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }


//    @Bean
//    public LocaleResolver cookieLocaleResolver() {
//        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//        cookieLocaleResolver.setCookieName("system_lang");
//        cookieLocaleResolver.setDefaultLocale(Locale.KOREA);
//
//        return cookieLocaleResolver;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("system_lang");
//
//        return localeChangeInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }
}
