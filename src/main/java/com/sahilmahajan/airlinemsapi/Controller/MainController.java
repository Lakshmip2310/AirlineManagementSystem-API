package com.sahilmahajan.airlinemsapi.Controller;

import com.sahilmahajan.airlinemsapi.Operations.StoreUserDetails;
import com.sahilmahajan.airlinemsapi.Operations.UserOperations;
import com.sahilmahajan.airlinemsapi.Utils.CreateUserUtil;
import com.sahilmahajan.airlinemsapi.Utils.LoginUtil;
import com.sahilmahajan.airlinemsapi.Utils.SearchDetailsUtil;
import com.sahilmahajan.airlinemsapi.Utils.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MainController {

//    @PostMapping("/search")
//    public boolean FlightSearch(SearchDetailsUtil searchDetailsUtil) {
//
//        return false;
//    }

    @CrossOrigin(origins = "http://localhost")
    @PostMapping(value = "/signup", consumes = "application/json")
    public boolean CreateAccount(@Validated @RequestBody CreateUserUtil createUserUtil) {
        UserOperations userOperations = new UserOperations();
        System.out.println(createUserUtil.getName());
        System.out.println(createUserUtil.getEmailID());
        System.out.println(createUserUtil.getPassword());
        System.out.println(createUserUtil.getPhoneNumber());
        return userOperations.CreateUser(createUserUtil);
    }

    @CrossOrigin(origins = "http://localhost")
    @PostMapping(value = "/login", consumes = "application/json")
    public boolean UserLogin(@Validated @RequestBody LoginUtil loginUtil) {
        UserOperations userOperations = new UserOperations();
        System.out.println(loginUtil.getEmailID());
        System.out.println(loginUtil.getPassword());
        return userOperations.Login(loginUtil);
    }

    @CrossOrigin(origins = "http://localhost")
    @PostMapping(value = "/userdetails", consumes = "application/json")
    public void UserDetails(@RequestBody UserDetails userDetails) {
        System.out.println(userDetails.getAppCodeName());
        StoreUserDetails storeUserDetails = new StoreUserDetails();
        storeUserDetails.StoreDetails(userDetails);
    }
}
