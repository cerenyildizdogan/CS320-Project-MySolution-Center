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

@SessionAttributes({"username","password","level","usertypename","id","residentData","email","serviceData","serviceName",
        "requestData","requestid","userid","requestExpl","myRequestData"})
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
    public String listResidentsPage(ModelMap model){

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
    public String addResidentPage(ModelMap model){
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
    public String removeResidentPage(ModelMap model){
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
    public String listServicesPage(ModelMap model){
        List<String[]> data = conn.query("select serviceid, servicename,serviceExpl\n" +
                        "from services",
                (row, index) -> {
                    return new String[]{row.getString("serviceid"), row.getString("servicename"),
                            row.getString("serviceExpl")};
                });

        model.addAttribute("serviceData", data.toArray(new String[0][3]));

        return "listServices";
    }
    @GetMapping("/addService")
    public String addServicePage(ModelMap model){
        return "addService";
    }

    @PostMapping("/addService")
    public String addService(ModelMap model,@RequestParam String serviceName, @RequestParam String serviceExpl){

        model.put("serviceName",serviceName);
        model.put("serviceExpl",serviceExpl);


        String query = "INSERT INTO Services (servicename, serviceExpl) " +
                "VALUES ('"+serviceName+"','"+serviceExpl+"')";

        conn.update(query);
        return "addService";
    }
    @GetMapping("/removeService")
    public String removeServicePage(ModelMap model){
        return "removeService";
    }

    @PostMapping("/removeService")
    public String removeService(ModelMap model, @RequestParam String servicename){
        if(servicename == null){
            model.put("errorMessage","Please enter valid service name");
            return "removeService";
        }

        String query = "DELETE FROM Services WHERE servicename = '"+servicename+"'";
        conn.update(query);

        return "removeService";
    }


    @GetMapping("listRequests")
    public String listRequestsPage(ModelMap model){

        List<String[]> data = conn.query( "SELECT requestid, username, email, servicename,  requestExpl, roomnumber, requestedDate, requestStatus, requestCompletedDate\n" +
                        "FROM Requests R\n" +
                        "NATURAL JOIN Users U\n" +
                        "NATURAL JOIN Services S\n" +
                        "WHERE R.serviceid = S.serviceid and U.userid = R.userid and usertypeid = 1\n"+
                        "ORDER BY requestedDate ASC",
                (row, index) -> {
                    return new String[]{row.getString("requestid"), row.getString("username"),
                            row.getString("email"), row.getString("servicename"),
                            row.getString("requestExpl"), row.getString("roomnumber"),
                            row.getString("requestedDate"), row.getString("requestStatus"),
                            row.getString("requestCompletedDate")};
                });

        model.addAttribute("requestData", data.toArray(new String[0][9]));


        return "listRequests";
    }

    @GetMapping("/updateRequests")
    public String updateRequestsPage(ModelMap model){

        return "updateRequests";
    }

    @PostMapping("/updateRequests")
    public String updateRequests(ModelMap model, @RequestParam int requestid){

        if(requestid == 0){
            model.put("errorMessage","Please enter valid request id");
            return "requestid";
        }

        model.put("requestid",requestid);

        String query = "UPDATE Requests SET requestStatus = 1 WHERE requestid = '"+requestid+"' ";
        String query2 = "UPDATE Requests SET requestCompletedDate = CURRENT_TIMESTAMP WHERE requestid = '"+requestid+"' ";

        conn.update(query);
        conn.update(query2);

        return "updateRequests";
    }

    @GetMapping("/listServicesForResidents")
    public String listServices2Page(ModelMap model){

        List<String[]> data = conn.query("select serviceid, servicename,serviceExpl\n" +
                        "from services",
                (row, index) -> {
                    return new String[]{row.getString("serviceid"), row.getString("servicename"),
                            row.getString("serviceExpl")};
                });

        model.addAttribute("serviceData", data.toArray(new String[0][3]));

        return "listServicesForResidents";
    }

    @GetMapping("/reportAnIssue/{userid}")
    public String reportAnIssuePage(ModelMap model){
        return "reportAnIssue";
    }

    @PostMapping("/reportAnIssue/{userid}")
    public String reportAnIssue(ModelMap model,@PathVariable("userid") int userid,@RequestParam int serviceid, @RequestParam String requestExpl){

        if(serviceid == 0){
            model.put("errorMessage","Please enter valid service id");
            return "reportAnIssue";
        }

        model.put("requestExpl",requestExpl);

        String query = "INSERT INTO Requests (userid, serviceid, requestExpl,requestCompletedDate)\n" +
                "VALUES ("+userid+","+serviceid+",'"+requestExpl+"',NULL ) ";

        conn.update(query);

        return "reportAnIssue";
    }

    @GetMapping("/myRequests/{userid}")
    public String myRequestsPage(ModelMap model,@PathVariable("userid") int userid){

        List<String[]> data = conn.query( "SELECT userid, username, email,roomnumber, servicename, requestExpl, requestedDate, requestStatus, requestCompletedDate\n" +
                        "FROM Users U\n" +
                        "NATURAL JOIN Requests R\n" +
                        "NATURAL JOIN Services S\n" +
                        "WHERE U.userid = R.userid and R.serviceid = S.serviceid and userid = "+userid+" ",
                (row, index) -> {
                    return new String[]{row.getString("userid"), row.getString("username"),
                            row.getString("email"), row.getString("roomnumber"),
                            row.getString("servicename"), row.getString("requestExpl"),
                            row.getString("requestedDate"), row.getString("requestStatus"),
                            row.getString("requestCompletedDate")};
                });

        model.addAttribute("myRequestData", data.toArray(new String[0][9]));

        return "myRequests";
    }

}
