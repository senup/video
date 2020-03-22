package com.wxapp.video.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override//配置图片映射的时候会导致swagger被同时影响到
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
                .addResourceLocations("file:D:/wxapp/")
		.addResourceLocations("classpath:/**")//swagger居然404了，可能拦截次序会影响，后面再做笔记吧
				.addResourceLocations("classpath:/resources/")//解决swagger静态资源被拦截的问题
				.addResourceLocations("classpath:/static/")
				.addResourceLocations("classpath:/public/");
	}
	
//	@Bean(initMethod="init")
//	public ZKCuratorClient zkCuratorClient() {
//		return new ZKCuratorClient();
//	}
//
//	@Bean
//	public MiniInterceptor miniInterceptor() {
//		return new MiniInterceptor();
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//
//		registry.addInterceptor(miniInterceptor()).addPathPatterns("/user/**")
//				       .addPathPatterns("/video/upload", "/video/uploadCover",
//				    		   			"/video/userLike", "/video/userUnLike",
//				    		   			"/video/saveComment")
//												  .addPathPatterns("/bgm/**")
//												  .excludePathPatterns("/user/queryPublisher");
//
//		super.addInterceptors(registry);
//	}

}
