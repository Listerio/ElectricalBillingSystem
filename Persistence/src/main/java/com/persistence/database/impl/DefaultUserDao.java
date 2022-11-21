package com.persistence.database.impl;

import com.persistence.database.UserDao;
import com.persistence.entities.User;
import com.persistence.entities.impl.DefaultUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultUserDao implements UserDao {

    private String query;

    @Override
    public void registerUser(User user) throws SQLException {
        query="INSERT INTO `electrical_billing_system`.`user_table` (`Consumer_id`," +
                " `first_name`, `last_name`, `user_name`,`password`, `email_address`, " +
                "`contact_address`) VALUES (?,?,?,?,?,?,?)";
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(query)){
            statement.setInt(1,user.getConsumerId());
            statement.setString(2,user.getFirstName());
            statement.setString(3,user.getLastName());
            statement.setString(4,user.getUserName());
            statement.setString(5,user.getPassword());
            statement.setString(6,user.getEmailAdress());
            statement.setString(7,user.getContactAddress());
            statement.executeUpdate();
        }
}
    @Override
    public User getUser(String email, String password) throws SQLException {
        User user=null;
        query="select * from `electrical_billing_system`.`user_table` where `email_address`=? and `password`=?";
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(query)) {
            statement.setString(1,email);
            statement.setString(2,password);
            
           try(ResultSet set=statement.executeQuery()){
               while (set.next()){
               int customerId=set.getInt(2);
               String firstName=set.getString(3);
               String lastName=set.getString(4);
               String userName=set.getString(5);
               String newPassword=set.getString(6);
               String newEmail=set.getString(7);
               String address=set.getString(8);
               user=new DefaultUser(customerId,firstName,lastName,userName,newEmail,newPassword,address);
               }
           }
        }
        return user;
    }

    @Override
    public User getUser(int customerId) throws SQLException {
        User user = null;
        query = "select * from `electrical_billing_system`.`user_table` where " +
                "`Consumer_id`=?";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()){
                    int NcustomerId = set.getInt(2);
                    String firstName = set.getString(3);
                    String lastName = set.getString(4);
                    String userName = set.getString(5);
                    String newPassword = set.getString(6);
                    String newEmail = set.getString(7);
                    String address = set.getString(8);
                user = new DefaultUser(NcustomerId, firstName, lastName, userName,
                        newEmail, newPassword, address);
                }
            }
        }
        return user;
    }
    @Override
    public List<User> userList() {
        List<User> users=new ArrayList<>();
        User user;
        query="SELECT * FROM electrical_billing_system.user_table;";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()){
                    int NcustomerId = set.getInt(2);
                    String firstName = set.getString(3);
                    String lastName = set.getString(4);
                    String userName = set.getString(5);
                    String newPassword = set.getString(6);
                    String newEmail = set.getString(7);
                    String address = set.getString(8);
                    user = new DefaultUser(NcustomerId, firstName, lastName, userName,
                            newEmail, newPassword, address);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

}

