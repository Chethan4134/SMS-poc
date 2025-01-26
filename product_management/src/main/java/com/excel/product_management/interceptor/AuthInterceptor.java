package com.excel.product_management.interceptor;

import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.exception.ProductModuleException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("X-Auth-Token");
        if ( authHeader.isEmpty()) {
            throw new ProductModuleException(ProductModuleConstants.INVALID_TOKEN);
        }
        return true;
    }
}
