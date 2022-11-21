package com.persistence.services.impl;

import com.persistence.database.UserDao;
import com.persistence.database.impl.DefaultUserDao;
import com.persistence.entities.User;
import com.persistence.services.UserManagementService;

import java.sql.SQLException;
import java.util.List;

public class DefaultUserManagementService implements UserManagementService {
    UserDao dao=new DefaultUserDao();
    @Override
    public void registerUser(User user) {
        user.setConsumerId(nextId()+1);
        try {
            dao.registerUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int nextId(){
        return getAllUser().size();
    }

    @Override
    public User getUser(String email, String password) {
        try {
            return dao.getUser(email,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserById(int id) {
        try {
            return dao.getUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUser() {
        return dao.userList();
    }


}
