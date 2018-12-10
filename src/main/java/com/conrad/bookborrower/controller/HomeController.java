package com.conrad.bookborrower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @CrossOrigin
    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}