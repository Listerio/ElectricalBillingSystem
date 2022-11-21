package com.persistence.database.impl;

import com.persistence.database.ApplianceDao;
import com.persistence.entities.Appliance;
import com.persistence.entities.User;
import com.persistence.entities.impl.DefaultAppliance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DefaultApplianceDao implements ApplianceDao {

    private String query;
    @Override


    public void registerAppliance(User user, List<Appliance> appliances) throws SQLException {
        query="insert into electrical_billing_system.user_appliance (fk_user_appliance,appliance_name,power,number,time)" +
                "values(?,?,?,?,?)";

        for (Appliance appliance:appliances) {
            try (Connection connection = DbUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, user.getConsumerId());
                statement.setString(2, appliance.getApplianceName());
                statement.setInt(3,appliance.getAppliancePower());
                statement.setInt(4,appliance.getNumberOfAppliances());
                statement.setDouble(5,appliance.getTimeUsed());
                statement.executeUpdate();
            }
        }
    }
    @Override
    public void registerAppliance(User user, Appliance appliance) throws SQLException {
        query="insert into electrical_billing_system.user_appliance (fk_user_appliance,appliance_name,power,number,time)" +
                "values(?,?,?,?,?)";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getConsumerId());
            statement.setString(2, appliance.getApplianceName());
            statement.setInt(3,appliance.getAppliancePower());
            statement.setInt(4,appliance.getNumberOfAppliances());
            statement.setDouble(5,appliance.getTimeUsed());
            statement.executeUpdate();
        }
    }
    @Override
    public Appliance retrieveAppliance(User user, String applianceName) throws SQLException {
       Appliance appliance=null;
       query="select * from electrical_billing_system.user_appliance where appliance_name=? and fk_user_appliance=?";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, applianceName);
            statement.setInt(2,user.getConsumerId());

            try(ResultSet set=statement.executeQuery()){
                while (set.next()){
                    appliance=new DefaultAppliance(set.getString(2),set.getInt(3)
                            ,set.getInt(4),set.getInt(5));
                }
            }
        }
            return appliance;
    }
    @Override
    public void editAppliance(User user,Appliance applianceOld, Appliance appliance) throws SQLException {
        deleteAppliance(user,applianceOld);
        registerAppliance(user,appliance);
    }
    @Override
    public void deleteAppliance(User user, Appliance appliance) throws SQLException {
        query="Delete from electrical_billing_system.user_appliance where appliance_name=? and fk_user_appliance=?";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, appliance.getApplianceName());
            statement.setInt(2,user.getConsumerId());
            statement.executeUpdate();
        }
    }
    @Override
    public List<Appliance> getAppliancePerUserId(int userId) throws SQLException {
        query = "select * from electrical_billing_system.user_appliance where fk_user_appliance=?";
        Appliance appliance;
        List<Appliance> appliances=new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    appliance=new DefaultAppliance(set.getString(2),set.getInt(3)
                            ,set.getInt(4),set.getInt(5));
                    appliances.add(appliance);
                }
            }
        }
        return appliances;
    }



}
