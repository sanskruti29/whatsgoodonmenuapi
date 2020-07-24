package com.whatsgoodonmenu.api.data;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Login {
    @Id
    public String email;
    public String password;
}