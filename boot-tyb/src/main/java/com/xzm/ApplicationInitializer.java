package com.xzm;

import com.xzm.modules.tyb.config.GlobalExceptionResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
@Order(1)
public class ApplicationInitializer implements WebApplicationInitializer {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @Override
    public void onStartup(ServletContext container)
            throws ServletException {
        logger.debug("===ApplicationInitializer==");
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    }
}