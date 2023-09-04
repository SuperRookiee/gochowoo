package kr.co.chunjae.gochowoo.controller.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminFilterConfig {

    @Bean
    public AdminFilter adminFilter() {
        return new AdminFilter();
    }

    @Bean
    public FilterRegistrationBean<AdminFilter> filter1Registration() {
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(adminFilter());
        registrationBean.addUrlPatterns("/admin");
        registrationBean.addUrlPatterns("/api/admin");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}