/* package edu.ozu.cs320project.controllers;

import edu.ozu.cs320project.services.LoginService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = AppController.class)
@ActiveProfiles("test")
class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    AppController controller = new AppController(); // Arrange

    ModelMap model;
    String username;
    String password;
    String email;
    String gsm;
    String roomnumber;
    String serviceName;
    String serviceExpl;
    WebRequest request;
    SessionStatus session;
    int requestid;
    int userid;
    int serviceid;
    String requestExpl;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void index() {
        String response = controller.index(model); // Act
        assertEquals("index", response); // Assert
    }

    @Test
    void loginPage() {
    }

    @Test
    void login() {
    }

    @Test
    void logout() {
    }

    @Test
    void residentPage() {
    }

    @Test
    void doPage() {
    }

    @Test
    void listResidentsPage() {
    }

    @Test
    void addResidentPage() {
    }

    @Test
    void addResident() {
    }

    @Test
    void removeResidentPage() {
    }

    @Test
    void removeResident() {
    }

    @Test
    void listServicesPage() {
    }

    @Test
    void addServicePage() {
    }

    @Test
    void addService() {
    }

    @Test
    void removeServicePage() {
    }

    @Test
    void removeService() {
    }

    @Test
    void listRequestsPage() {
    }

    @Test
    void updateRequestsPage() {
    }

    @Test
    void updateRequests() {
    }

    @Test
    void listServices2Page() {
    }

    @Test
    void reportAnIssuePage() {
    }

    @Test
    void reportAnIssue() {
    }

    @Test
    void myRequestsPage() {
    }
} */

/*
package edu.ozu.cs320project.controllers;

import edu.ozu.cs320project.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    AppController controller = new AppController(); // Arrange
    ModelMap model;
    String username;
    String password;
    String email;
    String gsm;
    String roomnumber;
    String serviceName;
    String serviceExpl;
    WebRequest request;
    SessionStatus session;
    int requestid;
    int userid;
    int serviceid;
    String requestExpl;

    @Test
    void index() {
        String response = controller.index(model); // Act
        assertEquals("index", response); // Assert
    }

    @Test
    void loginPage() {
        String response = controller.loginPage(model); // Act
        assertEquals("login", response); // Assert
    }

    @Test
    void login() {
        String response = controller.login(model, username, password); // Act
        assertEquals("login", response); // Assert
    }

    @Test
    void residentPage() {
        String response = controller.residentPage(model); // Act
        assertEquals("residentPage", response); // Assert
    }

    @Test
    void doPage() {
        String response = controller.doPage(model); // Act
        assertEquals("doPage", response); // Assert
    }

} */

package edu.ozu.cs320project.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    AppController controller = new AppController(); // Arrange
    ModelMap model;
    String username;
    String password;
    String email;
    String gsm;
    String roomnumber;
    String serviceName;
    String serviceExpl;
    WebRequest request;
    SessionStatus session;
    int requestid;
    int userid;
    int serviceid;
    String requestExpl;

    @Test
    void index() {
        String response = controller.index(model); // Act
        assertEquals("index", response); // Assert
    }

    @Test
    void loginPage() {
        String response = controller.loginPage(model); // Act
        assertEquals("login", response); // Assert
    }

    @Test
    void login() {
        String response = controller.login(model, username, password); // Act
        assertEquals("login", response); // Assert
    }

    @Test
    void logout() {
        String response = controller.logout(model, request, session); // Act
        assertEquals("logout", response); // Assert
    }

    @Test
    void residentPage() {
        String response = controller.residentPage(model); // Act
        assertEquals("residentPage", response); // Assert
    }

    @Test
    void doPage() {
        String response = controller.doPage(model); // Act
        assertEquals("doPage", response); // Assert
    }

    @Test
    void listResidentsPage() {
        String response = controller.listResidentsPage(model); // Act
        assertEquals("listResidents", response); // Assert
    }

    @Test
    void addResidentPage() {
        String response = controller.addResidentPage(model); // Act
        assertEquals("addResident", response); // Assert

    }

    @Test
    void addResident() {
        String response2 = controller.addResident(model, username, password, email, gsm, roomnumber); // Act
        assertEquals("addResident", response2); // Assert
    }

    @Test
    void removeResidentPage() {
        String response = controller.removeResidentPage(model); // Act
        assertEquals("removeResident", response); // Assert

    }

    @Test
    void removeResident() {
        String response2 = controller.removeResident(model, email); // Act
        assertEquals("removeResident", response2); // Assert
    }

    @Test
    void listServicesPage() {
        String response = controller.listServicesPage(model); // Act
        assertEquals("listServices", response); // Assert
    }

    @Test
    void addServicePage() {
        String response = controller.addServicePage(model); // Act
        assertEquals("addService", response); // Assert

    }

    @Test
    void addService() {
        String response2 = controller.addService(model, serviceName, serviceExpl); // Act
        assertEquals("addService", response2); // Assert
    }

    @Test
    void removeServicePage() {
        String response = controller.removeServicePage(model); // Act
        assertEquals("removeService", response); // Assert
    }

    @Test
    void removeService() {
        String response2 = controller.removeService(model, serviceName); // Act
        assertEquals("removeService", response2); // Assert
    }


    @Test
    void listRequestsPage() {
        String response = controller.listRequestsPage(model); // Act
        assertEquals("listRequests", response); // Assert
    }

    @Test
    void updateRequestsPage() {
        String response = controller.updateRequestsPage(model); // Act
        assertEquals("updateRequests", response); // Assert
    }

    @Test
    void updateRequests() {
        String response2 = controller.updateRequests(model, requestid); // Act
        assertEquals("updateRequests", response2); // Assert
    }

    @Test
    void listServices2Page() {
        String response = controller.listServices2Page(model); // Act
        assertEquals("listServices2", response); // Assert
    }

    @Test
    void reportAnIssuePage() {
        String response = controller.reportAnIssuePage(model); // Act
        assertEquals("reportAnIssue", response); // Assert
    }

    @Test
    void reportAnIssue() {
        String response2 = controller.reportAnIssue(model, userid, serviceid, requestExpl); // Act
        assertEquals("reportAnIssue", response2); // Assert
    }

    @Test
    void myRequestsPage() {
        String response = controller.myRequestsPage(model, userid); // Act
        assertEquals("myRequests", response); // Assert
    }
}