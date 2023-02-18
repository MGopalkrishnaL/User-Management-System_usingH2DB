package com.AssignmentGeekster.User.Management.System.util;

import com.AssignmentGeekster.User.Management.System.model.User;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidations {
    public static List<String> validateUser(JSONObject json){
        List<String> errorList = new ArrayList<>();
        if(!json.has("user_Name")){
            errorList.add("user_Name");
        }
        if(!json.has("user_DateOfBirth")){
            errorList.add("user_DateOfBirth");
        }
        if(!json.has("user_Email")){
            errorList.add("user_Email");
        }
        if(!json.has("user_Id")){
            errorList.add("user_Id");
        }
        if(json.has("user_PhoneNumber")){
            if(! validatemobile(json.getString("user_PhoneNumber")))
                    errorList.add("Add valid phone number");
        }else {
            errorList.add("user_PhoneNumber");
        }
        String dateOfBirth = json.getString("user_DateOfBirth");
        if(dateOfBirth.charAt(2)!='-'||dateOfBirth.charAt(5)!='-'||dateOfBirth.length()!=10){
            errorList.add("User_DateOfBirth should be in the format of yyyy-mm-dd");
        }

        return errorList;
    }
    public static User setUser(@NotNull JSONObject json) {
        User user = new User();
        user.setUser_Id(json.getInt("user_Id"));
        user.setUser_Name(json.getString("user_Name"));
        user.setUser_Email(json.getString("user_Email"));
        user.setUser_DateOfBirth(json.getString("user_DateOfBirth"));
        user.setUser_PhoneNumber(json.getString("user_PhoneNumber"));
        return user;
    }
    public static boolean validatemobile(String mobile){
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(mobile);
        return (match.find() && match.group().equals(mobile));
    }
}
