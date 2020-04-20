package com.gls.sio.console.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/").setCachePeriod(31556926);
       registry.addResourceHandler("/asset/**").addResourceLocations("/resources/asset/").setCachePeriod(31556926);
       registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/").setCachePeriod(31556926);
   }
     
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
}