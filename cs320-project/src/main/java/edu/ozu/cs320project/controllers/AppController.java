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

import java.util.List;

@Controller
@SessionAttributes({"username","password","level","usertypename","id","residentData","email","serviceData","serviceName","userid"})
public class AppController {

    @Autowired
    LoginService service;

    @Autowired
    JdbcTemplate conn;

    @GetMapping("/")
    public String index(ModelMap model){
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(ModelMap model){
        return "login";
    }

    @PostMapping("/login")
    public String login(ModelMap model, @RequestParam String username, @RequestParam String password){

        password = Salter.salt(password, "CS320Project");

        if(!service.validate(username,password)){
            model.put("errorMessage","Invalid Credentials");
            return "login";
        }
        Integer usertypeid = service.getUserType(username, password);
        String usertypename = service.getUserTypeName(username,password);
        String name = service.getUsername(username,password);
        int userid = service.getUserID(username);


        model.put("id", usertypeid.toString());
        model.put("usertypename",usertypename);
        model.put("userid",userid);
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
    public String logout(ModelMap model, WebRequest request, SessionStatus session){
        session.setComplete();
        request.removeAttribute("username",WebRequest.SCOPE_SESSION);

        return "redirect:/login";
    }

    @GetMapping("/residentPage")
    public String residentPage(ModelMap model){
        return "residentPage";
    }

    @GetMapping("/doPage")
    public String doPage(ModelMap model){
        return "doPage";
    }

    @GetMapping("/listResidents")
    public String listResidents(ModelMap model){

        List<String[]> data = conn.query("select userid, email,usertypename,username,gsm, roomnumber, registirationdate\n" +
                        "from users natural join usertypes\n" +
                        "where users.usertypeid = usertypes.usertypeid and usertypeid = 1\n",
                (row, index) -> {
                    return new String[]{row.getString("userid"), row.getString("email"),
                            row.getString("usertypename"), row.getString("username"),
                            row.getString("gsm"), row.getString("roomnumber"),
                            row.getString("registirationdate")};
                });

        model.addAttribute("residentData", data.toArray(new String[0][7]));

        return "listResidents";
    }

    @GetMapping("/addResident")
    public String addResident(ModelMap model){
        return "addResident";
    }

    @PostMapping("/addResident")
    public String addResident(ModelMap model,@RequestParam String username,@RequestParam String userpassword,@RequestParam String email,@RequestParam String gsm,
                              @RequestParam String roomnumber){

        userpassword = Salter.salt(userpassword,"CS320Project");
        model.put("username",username);
        model.put("userpassword",userpassword);
        model.put("email",email);
        model.put("gsm",gsm);
        model.put("roomnumber",roomnumber);

        String query = "INSERT INTO Users (usertypeid, username, userpassword, email, gsm, roomNumber) " +
                "VALUES (1,'"+username+"','"+userpassword+"','"+email+"','"+gsm+"','"+roomnumber+"')";

        conn.update(query);

        return "addResident";

    }

    @GetMapping("/removeResident")
    public String removeResident(ModelMap model){
        return "removeResident";
    }

    @PostMapping("/removeResident")
    public String removeResident(ModelMap model, @RequestParam String email){
        if(email == null){
            model.put("errorMessage","Please enter valid email");
            return "removeResident";
        }

        String query = "DELETE FROM Users WHERE email = '"+email+"'";
        conn.update(query);

        return "removeResident";
    }

    @GetMapping("/listServices")
    public String listServices(ModelMap model){
        List<String[]> data = conn.query("select serviceid, servicename,serviceExpl\n" +
                        "from services",
                (row, index) -> {
                    return new String[]{row.getString("serviceid"), row.getString("servicename"),
                            row.getString("serviceExpl")};
                });

        model.addAttribute("serviceData", data.toArray(new String[0][3]));

        return "listServices";
    }

}
