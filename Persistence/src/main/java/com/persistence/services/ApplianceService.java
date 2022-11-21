package com.persistence.services;


import com.persistence.entities.Appliance;
import com.persistence.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface ApplianceService  {
    void  registerAppliance(User user, List<Appliance> appliances) ;
    void  registerAppliance(User user,Appliance appliance)  ;
    Appliance  retrieveAppliance(User user,String applianceName) ;
    void  editAppliance(User user,Appliance old,Appliance appliance)  ;
    void  deleteAppliance(User user,Appliance appliance) ;
    List<Appliance> getAppliancePerUserId(int userId)  ;
}
