package com.whatsgoodonmenu.api.data;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Visitor {
    @Id
    String id;
    String ip;
    String device;
}