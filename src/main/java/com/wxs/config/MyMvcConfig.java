package com.wxs.config;

import com.wxs.component.MylocalResoler;
import com.wxs.filter.MyFilter;
import com.wxs.interceptor.LoginHandlerInterceptor;
import com.wxs.listener.MyListener;
import com.wxs.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.EventListener;

/**
 * @ClassName: MyMvnConfig
 * @Author: WuXiangShuai
 * @Time: 16:49 2019/8/30.
 * @Description:
 */
// 全面接管 SpringMVC
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    // 转发请求
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //浏览器发送 /atguigu 转换成 /success
        registry.addViewController("/haha").setViewName("success");
    }

    //
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(false);
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/")
//                .addResourceLocations("classpath:/public/")
//                .addResourceLocations("classpath:/resources/");
//    }

    // 配置自定义国际化
    @Bean
    public LocaleResolver localeResolver() {
        return new MylocalResoler();
    }

    // 配置自定义拦截器
//    @Bean
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new
//                LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html", "/", "/user/login");
//
//    }

    // 配置 Servlet
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        bean.setServlet(new MyServlet());
        return bean;
    }

    // 配置监听器
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> bean = new ServletListenerRegistrationBean<>();
        bean.setListener(new MyListener());
        return bean;
    }

    // 配置过滤器
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<MyFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new MyFilter());
        filter.setUrlPatterns(Arrays.asList("/hello", "/login"));
        return filter;
    }
}
