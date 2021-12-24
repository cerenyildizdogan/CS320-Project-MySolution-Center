package edu.ozu.cs320project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @GetMapping("/")
    public String index(ModelMap model) {
        return "index";
    }

}
