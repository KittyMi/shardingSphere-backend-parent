package com.sphere.web.interceptor;

import com.sphere.core.utils.SpringToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.StringJoiner;

import static com.sphere.core.utils.RequestUtil.getDeviceType;
import static com.sphere.core.utils.RequestUtil.ip;

/**
 * @author andy_lai
 * @date 2019/10/30 11:33
 * desc: LogInterceptor
 */
@Slf4j
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringJoiner sj = new StringJoiner("|");
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            sj.add(key + " : " + request.getHeader(key));
        }
        sj.add("uri: " + request.getRequestURI());
        log.info("[preHandle] {}", sj.toString());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        StringJoiner sj = new StringJoiner(" | ");

        sj.add(request.getRemoteHost());
        sj.add(String.valueOf(request.getRemotePort()));

        sj.add(request.getRequestURL().toString());
        sj.add(request.getHeader("user-agent"));
        sj.add(request.getHeader("referer"));
        sj.add(request.getHeader("X-Forwarded-For"));

        log.debug("[postHandle] {}", sj.toString());

        String ip = ip(request);
        String url=request.getRequestURL().toString();
        String referer=request.getHeader("referer");

        super.postHandle(request, response, handler, modelAndView);
    }


}
