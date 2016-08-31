package com.hpe.devops.apigatewayservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class ApigatewayCorsConf {

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowCredentials(true);
		
		config.addAllowedOrigin("*");
		
		config.addAllowedHeader("content-type");
		
		List<String> methods = new ArrayList<String>();
		
		methods.add("GET");
		methods.add("POST");
		methods.add("PUT");
		methods.add("HEAD");
		methods.add("DELETE");
		methods.add("TRACE");
		methods.add("OPTIONS");
		methods.add("PATCH");
		
		config.setAllowedMethods(methods);
		
		config.setMaxAge(1800l);
		
		source.registerCorsConfiguration("/**", config);
		
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		
		bean.setOrder(0);
		
		System.out.println("hehe");
		
		return bean;
	}
}
