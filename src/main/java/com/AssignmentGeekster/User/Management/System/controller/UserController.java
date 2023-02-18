package com.AssignmentGeekster.User.Management.System.controller;

import com.AssignmentGeekster.User.Management.System.model.User;
import com.AssignmentGeekster.User.Management.System.service.IUserService;
import com.AssignmentGeekster.User.Management.System.util.UserValidations;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    IUserService iUserService;
    @GetMapping("/getAllUser")
//    http://localhost:8080/api/User/getAllUser
    public List<User> getAllUser(){
        return iUserService.getAll();
    }
    @GetMapping("/getuser/{userid}")
//    http://localhost:8080/api/User/getuser/{userid}
    public User getUser(@PathVariable Integer userid) {

        return iUserService.getUsingId(userid);
    }
    @PostMapping("/adduser")
//    http://localhost:8080/api/User/adduser
    public ResponseEntity<String> addUser(@Valid @RequestBody String User){
            JSONObject json = new JSONObject(User);
            List<String> validation = UserValidations.validateUser(json);
            if(validation.isEmpty()){
                User user = UserValidations.setUser(json);
                iUserService.saveUser(user);
                return new ResponseEntity<>("Saved the data Successfully",HttpStatus.CREATED);
            }else{
                String [] arr = Arrays.copyOf(validation.toArray(),validation.size(),String[].class);

                return new ResponseEntity<>("Required param missing"+Arrays.toString(arr),HttpStatus.BAD_GATEWAY);
            }
    }

    @PutMapping("/updateUserInfo")
//    http://localhost:8080/api/User/updateUserInfo
    public String UpdateUser(@RequestBody User user,@RequestParam Integer UserId ){
        User user1 = getUser(UserId);
        JSONObject jsonObject = new JSONObject(user);

        user1.setUser_Name(jsonObject.getString("user_Name"));
        user1.setUser_Email(jsonObject.getString("user_Email"));
        user1.setUser_DateOfBirth(jsonObject.getString("user_DateOfBirth"));
        user1.setUser_PhoneNumber(jsonObject.getString("user_PhoneNumber"));
        return iUserService.Update(user1);
    }
    @DeleteMapping("deleteUser/{UserId}")
//    http://localhost:8080/api/User/deleteUser/{UserId}
    public String deleteUser(@PathVariable Integer UserId){
        return iUserService.deleteUser(UserId);
    }

}
