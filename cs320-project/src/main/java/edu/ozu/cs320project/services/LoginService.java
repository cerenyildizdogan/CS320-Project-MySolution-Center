package edu.ozu.cs320project.services;

import edu.ozu.cs320project.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    JdbcTemplate conn;

    public boolean validate(String username, String password){

        List<Map<String, Object>> response = conn.queryForList(
                "SELECT * FROM users WHERE email = ? AND userpassword = ?", new Object[]{ username, password });

        return response.size() == 1;
    }
    public int getUserType(String username, String password) {

        RowMapper<User> rm = (RowMapper<User>) (ResultSet result, int rowNum) -> {

            User user = new User();

            user.setUsertypeid(result.getInt("usertypeid"));

            return user;
        };

        String sql = "SELECT * FROM users WHERE email = ? AND userpassword = ?";


        User user = (User) conn.queryForObject(sql, new Object[]{ username, password }, rm);
        assert user != null;
        return user.getUsertypeid();
    }
    public String getUserTypeName(String username, String password) {

        RowMapper<User> rm = (RowMapper<User>) (ResultSet result, int rowNum) -> {

            User user = new User();

            user.setType(result.getString("usertypename"));

            return user;
        };

        String sql = "SELECT * FROM users NATURAL JOIN usertypes " +
                "WHERE users.usertypeid = usertypes.usertypeid and email = ? AND userpassword = ?";


        User usertype = (User) conn.queryForObject(sql, new Object[]{ username, password }, rm);
        assert usertype != null;
        return usertype.getType();
    }
    public int getUserID(String username) {

        RowMapper<User> rm = (RowMapper<User>) (ResultSet result, int rowNum) -> {

            User user = new User();

            user.setUserid(result.getInt("userid"));



            return user;
        };

        String sql = "SELECT * FROM users WHERE email = ?";


        User userid = (User) conn.queryForObject(sql, new Object[]{ username}, rm);
        assert userid != null;
        return userid.getUserid();
    }

    public String getUsername(String username, String password) {

        RowMapper<User> rm = (RowMapper<User>) (ResultSet result, int rowNum) -> {

            User user = new User();

            user.setUsername(result.getString("username"));

            return user;
        };

        String sql = "SELECT * FROM users WHERE email = ? AND userpassword = ?";

        User name = (User) conn.queryForObject(sql, new Object[]{ username, password }, rm);
        assert name != null;
        return name.getUsername();
    }
}