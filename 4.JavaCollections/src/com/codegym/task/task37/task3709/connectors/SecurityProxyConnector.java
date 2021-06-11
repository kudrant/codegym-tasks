package com.codegym.task.task37.task3709.connectors;

import com.codegym.task.task37.task3709.security.SecurityChecker;

public class SecurityProxyConnector implements Connector {
    SecurityChecker securityChecker;
    SimpleConnector simpleConnector;

    public SecurityProxyConnector(String resourceString) {
        this.simpleConnector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()) {
            simpleConnector.connect();
        }
    }
}
