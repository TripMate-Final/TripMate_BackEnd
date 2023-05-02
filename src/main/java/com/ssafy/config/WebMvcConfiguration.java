package com.ssafy.config;
import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@MapperScan(basePackages = {"com.ssafy.**.mapper"})
public class WebMvcConfiguration implements WebMvcConfigurer{
//	private final List<String> patterns = Arrays.asList("/article/*" , "/admin/**" , "/user/list");
//	private ConfirmInterceptor confirmInterceptor;
//	
//	public WebMvcConfiguration(ConfirmInterceptor confirmInterceptor) {
//		this.confirmInterceptor = confirmInterceptor;
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(confirmInterceptor).addPathPatterns(patterns);
//	}

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
////		registry.addMapping("/**").allowedOrigins("http://localhost:8080" , "http://70.12.103.80");
//		registry.addMapping("/**").allowedOrigins("*").allowedMethods(HttpMethod.GET.name() , HttpMethod.POST.name() , HttpMethod.PUT.name() , 
//				HttpMethod.DELETE.name() , HttpMethod.OPTIONS.name() , HttpMethod.PATCH.name() , HttpMethod.HEAD.name())
//		.maxAge(1800);
//	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
//		registry.addRedirectViewController("/", "/list");
	}
}
