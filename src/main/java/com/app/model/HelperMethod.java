package com.app.model;

import javax.validation.constraints.Email;

public class HelperMethod {
    public static String removeDotEmail(@Email(message = "please provide a valid email") String input){
        String[] inputSplit = input.split("@", 2);
        return inputSplit.length < 2 ? inputSplit[0] :
                inputSplit[0].replace(".", "") +
                "@" + inputSplit[1];
    }
}
