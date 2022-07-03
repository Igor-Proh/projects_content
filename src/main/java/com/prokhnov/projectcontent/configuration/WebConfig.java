package com.prokhnov.projectcontent.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("com.prokhnov.**")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/jsp/**").addResourceLocations("/WEB-INF/jsp/");
    }

    @Override
    public void configureViewResolvers(final ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }
}