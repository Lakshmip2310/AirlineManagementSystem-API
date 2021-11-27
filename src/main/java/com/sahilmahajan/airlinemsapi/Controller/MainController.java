package com.sahilmahajan.airlinemsapi.Controller;

import com.sahilmahajan.airlinemsapi.Operations.UserOperations;
import com.sahilmahajan.airlinemsapi.Utils.CreateUserUtil;
import com.sahilmahajan.airlinemsapi.Utils.LoginUtil;
import com.sahilmahajan.airlinemsapi.Utils.SearchDetailsUtil;
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

    @PostMapping("/signup")
    public boolean CreateAccount(@Valid @RequestBody CreateUserUtil createUserUtil) {
        UserOperations userOperations = new UserOperations();
        return userOperations.CreateUser(createUserUtil);
    }

    @PostMapping("/login")
    public boolean UserLogin(@Valid @RequestBody LoginUtil loginUtil) {
        UserOperations userOperations = new UserOperations();
        return userOperations.Login(loginUtil);
    }
}
