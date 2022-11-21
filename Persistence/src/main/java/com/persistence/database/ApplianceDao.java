package com.persistence.database;

import com.persistence.entities.Appliance;
import com.persistence.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface ApplianceDao {
    void  registerAppliance(User user,List<Appliance> appliances) throws SQLException;
    void  registerAppliance(User user,Appliance appliance) throws SQLException;
    Appliance  retrieveAppliance(User user,String applianceName) throws SQLException;
    void  editAppliance(User user,Appliance old,Appliance appliance) throws SQLException;
    void  deleteAppliance(User user,Appliance appliance) throws SQLException;
    List<Appliance> getAppliancePerUserId(int userId) throws SQLException;
}
