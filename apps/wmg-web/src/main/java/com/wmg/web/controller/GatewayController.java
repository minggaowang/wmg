package com.wmg.web.controller;

import com.wmg.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by yuanqi on 2017/2/6.
 */
@Controller
@RequestMapping(value="gateway")
public class GatewayController {
    private static final Logger logger = LoggerFactory.getLogger(GatewayController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if(!StringUtils.isEmpty(session.getAttribute(Constants.LOGIN_ROLE))){
                session.removeAttribute((String)session.getAttribute(Constants.LOGIN_USER));
                session.removeAttribute(Constants.LOGIN_USER);
                session.removeAttribute(Constants.LOGIN_ROLE);
                Enumeration em = session.getAttributeNames();
                while(em.hasMoreElements()){
                    session.removeAttribute(em.nextElement().toString());
                }
        }

        return "index";
    }
}
