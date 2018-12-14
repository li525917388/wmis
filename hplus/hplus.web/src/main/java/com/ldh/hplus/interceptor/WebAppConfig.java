package com.ldh.hplus.interceptor;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	InterceptorConfig interceptorConfig;
	
	@Value("${ldh.exclude.path.patterns}")
	private String noCheckList;
	
	@Value("${ldh.dir}")
	private String dir;	//虚拟路径地址
	
	@Value("${ldh.dir_path}")
	private String dir_path;	//虚拟路径地址

	@Override  
    public void addInterceptors(InterceptorRegistry registry) { 
		 System.out.println("addInterceptors----------------------");
		 System.out.println("excludePathPatterns----------------------");
		 System.out.println(noCheckList);
		 System.out.println("----------------------");
		 
		 if(noCheckList == null){
			 
			 noCheckList = "/sys/user/login";
		 }
		 
		 String[] noChecks = noCheckList.split(",");
		 
        //注册自定义拦截器，添加拦截路径和排除拦截路径  
        registry.addInterceptor(interceptorConfig).addPathPatterns("/**").excludePathPatterns(noChecks);  
    }
	 
	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }
	
	@Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
	
	// 就是这个
    /*@Bean
    public HttpPutFormContentFilter httpPutFormContentFilter() {
        return new HttpPutFormContentFilter();
    }*/
	
	/**
	 * 配置虚拟路径
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("虚拟路径=====>" + dir);
		System.out.println("虚拟路径地址=====>" + dir_path);
        registry.addResourceHandler(dir).addResourceLocations("file:" + dir_path);  
        super.addResourceHandlers(registry);
    }

}
