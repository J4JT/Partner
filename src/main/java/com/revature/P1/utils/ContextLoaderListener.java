package com.revature.P1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.P1.daos.User_Daos;
import com.revature.P1.services.UserService;
import com.revature.P1.servlets.TestServlet;
import com.revature.P1.servlets.UserServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* ObjectMapper provides functionality for reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects) */
        ObjectMapper mapper = new ObjectMapper();

        /* Dependency Injection */
        TestServlet testServlet = new TestServlet();
        UserServlet userServlet = new UserServlet(mapper, new UserService(new User_Daos()));

        /* Need ServletContext class to map whatever servlet to url path. */
        ServletContext context = sce.getServletContext();
        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
        context.addServlet("TestServlet", testServlet).addMapping("/test");

        //context.addServlet("SignupServlet",signupServlet).addMapping("/signup/*");
       // context.addServlet("LoginServlet",loginServlet).addMapping("/LoginServlet");


    }
}
