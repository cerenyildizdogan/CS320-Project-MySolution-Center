package edu.ozu.cs320project.controllers;


import edu.ozu.cs320project.Salter;
import edu.ozu.cs320project.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller

@SessionAttributes({"username","password","level","usertypename","id","email"})
public class AppController {

    @Autowired
    LoginService service;

    @Autowired
    JdbcTemplate conn;

    @GetMapping("/")
    public String index(ModelMap model) {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(ModelMap model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(ModelMap model, @RequestParam String username, @RequestParam String password) {

        password = Salter.salt(password, "CS320Project");

        if (!service.validate(username, password)) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
        Integer usertypeid = service.getUserType(username, password);
        String usertypename = service.getUserTypeName(username, password);
        String name = service.getUsername(username, password);
        int userid = service.getUserID(username);


        model.put("id", usertypeid.toString());
        model.put("usertypename", usertypename);
        model.put("userid", userid);
        model.put("username", name);

        if (usertypeid == 1) {
            return "redirect:/residentPage";
        }
        if (usertypeid == 2) {
            return "redirect:/doPage";
        } else {
            return "login";
        }

    }

    @GetMapping("/logout")
    public String logout(ModelMap model, WebRequest request, SessionStatus session) {
        session.setComplete();
        request.removeAttribute("username", WebRequest.SCOPE_SESSION);

        return "redirect:/login";
    }

}
