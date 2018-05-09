package com.example.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by tangm on 2017/9/17.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ws").setViewName("/ws");
    }*/

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**").addResourceLocations("/templates/");
    }*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/ws").setViewName("/ws");
    }
}
