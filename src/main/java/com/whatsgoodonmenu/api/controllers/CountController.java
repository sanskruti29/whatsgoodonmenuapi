package com.whatsgoodonmenu.api.controllers;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import com.whatsgoodonmenu.api.data.Visitor;
import com.whatsgoodonmenu.api.services.VisitorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {

    @Autowired VisitorService visitorService;
    @GetMapping("/count")
    @CrossOrigin(origins = "*")
    public int count(){
        return visitorService.getTotalVisits();
    }

    @GetMapping("/visit")
    @CrossOrigin(origins = "*")
    public Visitor visit(HttpServletRequest request){
        Visitor visitor = visitorService.visit(request);
        return visitor;
    }

    @GetMapping("/unique")
    @CrossOrigin(origins = "*")
    public int unique(){
        return visitorService.getUniqueVisitors();
    }
}