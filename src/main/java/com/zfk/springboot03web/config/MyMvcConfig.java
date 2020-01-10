package com.zfk.springboot03web.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
//@EnableWebMvc  //用了这个无法WebMvcConfigurer就崩盘了，所以千万不要加！
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("MyMvcConfig000000000000000001");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/aaa").setViewName("index");


    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {  //拦截器
        System.out.println("我是拦截器");
//       registry.addInterceptor(new LoginHanderInterceptor())
//               .addPathPatterns("/**")
//               .excludePathPatterns("/css/*","/images/*","/js/*","scripts/*","/styles/*","/webfonts/*", "/","/index","/aaa"); //拦截所有页面除了
        //  /index是登录跳转的页面 不需要拦截 /是登录首页 不需要拦截
    }
}


