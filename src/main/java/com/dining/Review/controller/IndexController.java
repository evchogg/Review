package com.dining.Review.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String firstPage() {
        return "index.html";
    }

    
}
