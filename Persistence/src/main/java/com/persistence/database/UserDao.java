package com.persistence.database;

import com.persistence.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

   void registerUser(User user) throws SQLException;
   User getUser(String email, String password) throws SQLException;
   User getUser(int customerId) throws SQLException;
   List<User> userList();

}
