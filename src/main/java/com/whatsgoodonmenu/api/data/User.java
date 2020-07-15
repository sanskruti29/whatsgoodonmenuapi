package com.whatsgoodonmenu.api.data;

import lombok.Data;

@Data
public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
}