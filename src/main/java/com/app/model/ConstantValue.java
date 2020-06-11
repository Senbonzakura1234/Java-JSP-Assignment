package com.app.model;

public class ConstantValue {
    public static final String PasswordRegexRule = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]*$";

    public static String TagUsername = "username";
    public static String TagPassword = "password";

    public static String LoginTitle = "Login";
    public static String DashboardTitle = "Dashboard";

    public static String LoginRoute = "login";
    public static String DashboardRoute = "index";
    public static String[] redirectPath = {"/login", "/register"};

}
