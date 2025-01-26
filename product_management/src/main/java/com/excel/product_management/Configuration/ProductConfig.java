package com.excel.product_management.Configuration;

import com.excel.product_management.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProductConfig implements WebMvcConfigurer{

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/search/module/byId")
                .addPathPatterns("/search/Product/byId")
                .addPathPatterns("/search/Product/module/byId");


    }

}
