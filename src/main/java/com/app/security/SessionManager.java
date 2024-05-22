package com.app.security;

import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

public class SessionManager {

        private static final String SESSION_KEY = "activeUser";
        private static final String ROLE_KEY = "userRole";


        public static void setUsername(Object value) {
            VaadinSession.getCurrent().setAttribute(SESSION_KEY, value);
        }
        public static void setRole(Object value) {
            VaadinSession.getCurrent().setAttribute(ROLE_KEY, value);
        }

        public static void setAttribute(String key, Object value) {
            VaadinSession.getCurrent().setAttribute(key, value);
        }
        public static Object getAttribute(String key) {
            return VaadinSession.getCurrent().getAttribute(key);
        }
        public static String getUserName() {
            return VaadinSession.getCurrent().getAttribute(SESSION_KEY).toString();
        }

        public static String getRoleKey() {
            return VaadinSession.getCurrent().getAttribute(ROLE_KEY).toString();
        }
        public static void destroySession() {
                VaadinSession.getCurrent().getSession().invalidate();
            }

}
