package com.gls.sio.portal.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.gls.sio.portal")
@EnableWebMvc
public class ApplicationConfig extends WebMvcConfigurerAdapter {

	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/static/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/asset/**").addResourceLocations("/static/asset/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/static/js/").setCachePeriod(31556926);
		registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(31556926);
		registry.addResourceHandler("/product-images/**").addResourceLocations("/product-images/").setCachePeriod(31556926);
	}


	/**
	 * Optional. It's only required when handling '.' in @PathVariables which
	 * otherwise ignore everything after last '.' in @PathVaidables argument. It's a
	 * known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present
	 * in Spring 4.1.7. This is a workaround for this issue.
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer matcher) {
		matcher.setUseRegisteredSuffixPatternMatch(true);
	}
}
