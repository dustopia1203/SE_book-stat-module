package dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {
    public UserDAO() {
        super();
    }

    public boolean checkLogin(User user) {
        boolean res = false;
        String query = "SELECT name, role FROM tblUser WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = CON.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));
                res = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
