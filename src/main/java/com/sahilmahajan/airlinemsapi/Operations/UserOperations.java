package com.sahilmahajan.airlinemsapi.Operations;

import com.sahilmahajan.airlinemsapi.Repo.UserRepo;
import com.sahilmahajan.airlinemsapi.Utils.BCrypt;
import com.sahilmahajan.airlinemsapi.Utils.CreateUserUtil;
import com.sahilmahajan.airlinemsapi.Utils.LoginUtil;

public class UserOperations {

    public boolean CreateUser(CreateUserUtil createUserUtil) {

        //First verify if EmailID in DB or not.
        UserRepo userRepo = new UserRepo();

        if (userRepo.EmailCheck(createUserUtil.getEmailID())) {
            return false;
        }

        String Salt = BCrypt.gensalt(12);
        String HashPassword = BCrypt.hashpw(createUserUtil.getPassword(), Salt);

        if (!userRepo.SaltInsertion(createUserUtil.getEmailID(), Salt)) {
            return false;
        }

        if (!userRepo.InsertNewUserData(createUserUtil.getName(), createUserUtil.getEmailID(), createUserUtil.getPhoneNumber(), HashPassword)) {
            return false;
        }

        return true;
    }

    public boolean Login(LoginUtil loginUtil) {

        UserRepo userRepo = new UserRepo();

        if (!userRepo.EmailCheck(loginUtil.getEmailID())) {
            return false;
        }

        //TODO
        //Add try catch block
        String Salt = userRepo.GetSalt(loginUtil.getEmailID());

        if (Salt == null) {
            return false;
        }

        String HashPassword = BCrypt.hashpw(loginUtil.getPassword(), Salt);

        if (!userRepo.VerifyHash(loginUtil.getEmailID(), HashPassword)) {
            return false;
        }

        return true;
    }
}
