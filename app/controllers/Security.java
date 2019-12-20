package controllers;

import models.User;

public class Security extends Secure.Security {
    static boolean authenticate(String username, String password) {
        boolean ret = username != null
                && password != null
                && username.equals("林志鹏")
                && password.equals("123") ||
                username.equals("jack")//非管理员
                        && password.equals("123");
        String user = Security.connected();
        User u = User.find("byFullname", user).first();
        session.put("currentUser", username);
        return ret;
    }


    public static boolean check(String profile) {
        if (Security.isConnected()) {
            if (profile.equals("1")) {
                String user = Security.connected();
                User u = User.find("byEmail", user).first();
                return true;
            } else if (profile.equals("admin")) {
                String admin = Security.connected();
                User ad = User.find("byEmail", admin).first();
                return ad.isAdmin;
            } else if (profile.equals("user")) {
                String user = Security.connected();
                User u = User.find("byEmail", user).first();
                return !u.isAdmin;
            }

        }
        return true;
    }
}