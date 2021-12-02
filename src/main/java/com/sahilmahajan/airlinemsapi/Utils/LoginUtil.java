package com.sahilmahajan.airlinemsapi.Utils;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginUtil {

    @NotNull
    //@Max(50)
    @Pattern(regexp = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String EmailID;

    @NotNull
    //@Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
    private String Password;

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
