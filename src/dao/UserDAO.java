package dao;

import model.User;

public class UserDAO extends DAO {
    public UserDAO() {
        super();
    }

    public boolean checkLogin(User user) {
        boolean res = false;
        String query = "SELECT name, role FROM tblUser WHERE username = ? AND password = ?";

        return res;
    }
}
