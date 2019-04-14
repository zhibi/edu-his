package edu.his.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zhibi.frame.springmvc.interceptor.AdminInterceptor;
import zhibi.frame.springmvc.interceptor.ParamInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ParamInterceptor paramInterceptor;
    @Autowired
    private AdminInterceptor adminInterceptor;


    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(paramInterceptor).addPathPatterns("/**");
        adminInterceptor.setAdminLoginUrl("/login");
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/Css/**")
                .excludePathPatterns("/Js/**")
                .excludePathPatterns("/Images/**")
                .excludePathPatterns("/IMG/**")
                .excludePathPatterns("/assets/**")
                .excludePathPatterns("/verify")
                .excludePathPatterns("/login");
    }



}
