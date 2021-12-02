package com.sahilmahajan.airlinemsapi.Utils;

import javax.validation.constraints.*;

public class CreateUserUtil {

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[a-zA-Z][a-zA-Z]*")
    private String Name;

    @NotNull
    @Pattern(regexp = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String EmailID;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^\\d{10}$")
    private String PhoneNumber;

    @NotNull
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
