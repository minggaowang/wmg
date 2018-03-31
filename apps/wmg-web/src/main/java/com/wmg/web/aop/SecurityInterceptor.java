package com.wmg.web.aop;

import com.wmg.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: jz151
 * Date: 13-12-27
 * Time: 下午2:06
 * To change this template use File | Settings | File Templates.
 */
public class SecurityInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class.getName());

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String userpwd = (String) session.getAttribute(Constants.LOGIN_USER);
//        AuditAspect.setLoginUser(userpwd);
        if(StringUtils.isEmpty(userpwd)){
            logger.info("user not login");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login/toLogin");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
