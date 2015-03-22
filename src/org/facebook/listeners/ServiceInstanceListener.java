package org.facebook.listeners;

import org.facebook.services.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Tanveer on 3/11/2015.
 */
@WebListener
public class ServiceInstanceListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext sc = servletContextEvent.getServletContext();
        sc.setAttribute("DeleteHandler", new DeleteHandlerImpl());
        sc.setAttribute("InsertHandler", new InsertHandlerImpl());
        sc.setAttribute("LoginHandler", new LoginHandlerImpl());
        sc.setAttribute("RetrieveHandler", new RetrieveHandlerImpl());
        sc.setAttribute("UpdateHandler", new UpdateHandlerImpl());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
