package com.comscivisualized.backend;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setResourceBase("src/main/frontend");
        webAppContext.setParentLoaderPriority(true);

        // Enable directory listings if there's no index.html
        webAppContext.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "true");

        server.setHandler(webAppContext);

        server.start();
        server.join();
    }
}