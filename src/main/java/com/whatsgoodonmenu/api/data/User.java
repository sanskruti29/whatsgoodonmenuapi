package com.whatsgoodonmenu.api.data;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {
    public String firstName;
    public String lastName;
    @Id
    public String email;
    public String password;
}