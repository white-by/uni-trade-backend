package com.sysu.config.intercepor;

import com.sysu.common.ResultCode;
import com.sysu.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import io.jsonwebtoken.JwtException;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    public JwtInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;

//        String header = request.getHeader("Authorization");
//        response.setContentType("application/json;charset=UTF-8");
//
//        if (header == null || !header.startsWith("Bearer ")) {
//            response.getWriter().write("{\"code\":" + ResultCode.TOKEN_EXPIRED + ",\"msg\":\"缺少或无效的Token\",\"data\":{}}");
//            return false;
//        }
//
//        String token = header.substring(7);
//        try {
//            String userId = jwtUtil.parseToken(token);
//            request.setAttribute("userId", userId);
//            return true;
//        } catch (JwtException e) {
//            // token过期或无效都统一返回 TOKEN_EXPIRED
//            response.getWriter().write("{\"code\":" + ResultCode.TOKEN_EXPIRED + ",\"msg\":\"Token已过期或无效\",\"data\":{}}");
//            return false;
//        }
    }



}