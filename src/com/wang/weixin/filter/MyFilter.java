package com.wang.weixin.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anbang.Wang on 2016/5/10.
 */
public class MyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("----> " + httpServletRequest.getMethod() + "\t" + httpServletRequest.getRequestURI() + "\t");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
