package org.facebook.listeners;

import org.slf4j.LoggerFactory;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Tanveer on 3/11/2015.
 */
@WebListener
public class FacebookSessionListener implements HttpSessionListener {

    static private int activeSessions;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FacebookSessionListener.class);

    public static int getActiveSessions() {
        return activeSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        activeSessions++;
        logger.info("A NEW SESSION IS CREATED");
        logger.info("SESSION ID : " + httpSessionEvent.getSession().getId());
        logger.info("SESSION CREATED AT : " + httpSessionEvent.getSession().getCreationTime());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        activeSessions--;
        logger.info("A SESSION IS DESTROYED");
        logger.info("SESSION ID : " + httpSessionEvent.getSession().getId());
        logger.info("SESSION LAST ACCESSED AT : " + httpSessionEvent.getSession().getLastAccessedTime());
    }
}
